
import numpy as np
import pandas as pd
import sys


def check_input_arguments_in(argv):

    if ((len(argv) != 2) or (argv[1] != "Cleaned_No-Show_Dataset.csv")):
        print( \
            "\nPass interpreter 'python' the name of this script and the filename " + \
            "'Cleaned_No-Show_Dataset.csv', with or without single quotes." \
        )
        assert(False)


def the_filename_from(argv):

    check_input_arguments_in(argv)

    return argv[1]


def the_processed_dataset_based_on(the_name_of_the_file_with_the_dataset):

    the_dataset = pd.read_csv(the_name_of_the_file_with_the_dataset)

    # Converts objects to int64's.
    the_dataset["Gender"] = the_dataset["Gender"].replace(["F","M"], [0,1])

    # Converts objects to "dateTime64[ns, UTC]"'s.
    the_dataset["ScheduledDay"] = pd.to_datetime(the_dataset["ScheduledDay"])
    the_dataset["AppointmentDay"] = pd.to_datetime(the_dataset["AppointmentDay"])

    # Times are float64's.
    the_dataset.insert( \
        the_dataset.columns.get_loc("AppointmentDay")+1, \
        "TimeBetween", \
        (the_dataset["AppointmentDay"] - the_dataset["ScheduledDay"]) / np.timedelta64(1,"D") \
    )

    # Converts objects to int64's.
    the_dataset["No-show"] = the_dataset["No-show"].replace(["No","Yes"], [0,1])

    # All data are int64's or float64's.
    the_dataset = \
        the_dataset[[ \
            "Gender", "TimeBetween", "Age", "Scholarship", "Hypertension", "Diabetes", \
            "Alcoholism", "Handicap", "SMS_received", "No-show" \
        ]]

    # Cast int64's and float64's to float64's.
    the_dataset = the_dataset.astype("float64")

    return the_dataset


def the_independent_and_actual_dependent_variable_datasets_based_on(the_processed_dataset):

    independent_variable_dataset = \
        the_processed_dataset[[ \
            "Gender", "TimeBetween", "Age", "Scholarship", "Hypertension", "Diabetes",
            "Alcoholism", "Handicap", "SMS_received" \
        ]]


    actual_dependent_variable_dataset = the_processed_dataset[["No-show"]]

    return [independent_variable_dataset, actual_dependent_variable_dataset]


def the_independent_and_actual_dependent_variable_matrices_based_on(the_processed_dataset):

    [the_independent_variable_dataset, the_actual_dependent_variable_dataset] = \
        the_independent_and_actual_dependent_variable_datasets_based_on(the_processed_dataset)

    return [
        the_independent_variable_dataset.to_numpy(),
        the_actual_dependent_variable_dataset.to_numpy()
    ]


def the_linear_model_based_on(the_processed_dataset):

    [A, b] = \
        the_independent_and_actual_dependent_variable_matrices_based_on( \
            the_processed_dataset)

    A_T = np.transpose(A)

    psuedoinverse = np.matmul(np.linalg.inv(np.matmul(A_T, A)), A_T)

    x = np.matmul(psuedoinverse, b)

    return x


def the_dataset_with_predictions_based_on(the_processed_dataset, the_linear_model):

    [A, _] = \
        the_independent_and_actual_dependent_variable_matrices_based_on( \
            the_processed_dataset)

    the_predicted_dependent_variable_values = np.round(np.matmul(A, the_linear_model))

    the_dataset_with_predictions = the_processed_dataset.copy()

    the_dataset_with_predictions["Predicted"] = the_predicted_dependent_variable_values

    return the_dataset_with_predictions


def the_precision_and_recall_based_on_the_predictions_and_actual_values_from(dataset):

    true_positives = 0
    false_positives = 0
    true_negatives = 0
    false_negatives = 0

    for i in range(0, len(dataset.index)):
        if ((dataset.at[i, "Predicted"] == 1) and (dataset.at[i, "No-show"] == 1)):
            true_positives += 1
        elif ((dataset.at[i, "Predicted"] == 1) and (dataset.at[i, "No-show"] == 0)):
            false_positives += 1
        elif ((dataset.at[i, "Predicted"] == 0) and (dataset.at[i, "No-show"] == 0)):
            true_negatives += 1
        else:
            false_negatives += 1

    precision = true_positives / (true_positives + false_positives)
    recall = true_positives / (true_positives + false_negatives)

    return [precision, recall]


def output_stuff_about( \
    the_processed_dataset, the_linear_model, the_precision, the_recall):

    [the_independent_variable_values, _] = \
        the_independent_and_actual_dependent_variable_datasets_based_on(the_processed_dataset)

    print(
        "\nBased on the dataset in the file with the inputted filename, " + \
        "a linear model of the relationship between the number of no-shows " + \
        f"and the following {len(the_independent_variable_values.columns)} independent " + \
        "variables was developed.\n"
    )

    print(the_independent_variable_values.columns.to_list())

    print("\nBelow is a column vector of the coefficients for the independent variables.\n")

    print(the_linear_model)

    print(
        "\nPrecision: The proprotion of positive identifications that were actually " + \
        f"correct is {the_precision}."
    )

    print(
        "\nRecall: The proportion of actual positives that were identified correct is " + \
        f"{the_recall}.\n"
    )


if __name__ == "__main__":

    the_name_of_the_file_with_the_dataset = the_filename_from(sys.argv)

    the_processed_dataset = \
        the_processed_dataset_based_on(the_name_of_the_file_with_the_dataset)

    the_linear_model = the_linear_model_based_on(the_processed_dataset)

    the_dataset_with_predictions = \
        the_dataset_with_predictions_based_on(the_processed_dataset, the_linear_model)

    [the_precision, the_recall] = \
        the_precision_and_recall_based_on_the_predictions_and_actual_values_from( \
            the_dataset_with_predictions \
        )

    output_stuff_about( \
        the_processed_dataset, the_linear_model, the_precision, the_recall)