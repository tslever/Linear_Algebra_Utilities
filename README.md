# Math_Utilities
 A repository for math utilities.


<h3>Generate_Linear_Model_for_Cleaned_No-Show_Dataset.py</h3>

Generate_Linear_Model_for_Cleaned_No-Show_Dataset parses a filename corresponding to a Cleaned_No-Show_Dataset, and outputs information about a generated linear model.

<h5>Generate_Linear_Model_for_Cleaned_No-Show_Dataset.py on a Windows-10 PC</h5>

<ol>
    <li>Install Python 3.9.1 and pip.</li>
    <li>Clone repository.</li>
    <li>Open PowerShell in project directory.</li>
    <li>Install dependencies with "pip install -r requirements.txt"</li>
    <li>Run "Generate_Linear_Model_for_Cleaned_No-Show_Dataset.py 'Cleaned_No-Show_Dataset.csv'".</li>
    <li>To save output to a text file, pipe output using "python Put_in_RREF.py 'Cleaned_No-Show_Dataset.csv' | Out-File Info_about_Linear_Model.txt".</li>
</ol>


<h3>Put_in_RREF.py</h3>

Put_in_RREF parses a string representation of a matrix from a command-line argument into a numpy matrix and outputs a version of the matrix in Reduced Row Echelon Form. Additionally, Put_in_RREF outputs each step of the process of putting the inputted matrix into RREF.

<h5>Using Put_in_RREF.py on a Windows-10 PC</h5>

<ol>
    <li>Install Python 3.9.1 and pip.</li>
    <li>Clone repository.</li>
    <li>Open PowerShell in project directory.</li>
    <li>Install dependencies with "pip install -r requirements.txt"</li>
    <li>Run "python Put_in_RREF.py 'a11, a12, a13; a21, a22, a23'".<br/>
        Make sure matrix brackets are written as single quotes. <br/>
        Make sure all matrix values are present and are numerical values.<br/>
        Make sure row elements are separated by commas and rows are separated by semicolons.</li>
    <li>To save output to a text file, pipe output using "python Put_in_RREF.py 'a11, a12, a13; a21, a22, a23' | Out-File Example_Process.txt".</li>
</ol>


<h3>GCDFinder.java</h3>

GCDFinder represents an object that finds the Greatest Common Denominator of two integers. Usage on Windows:

<ol>
    <li>Download GCDFinder.java.</li>
    <li>Compile using PowerShell and the command, <u>javac -classpath "&lt;path to JRE's rt.jar&gt;" GCDFinder.java</u>.</li>
    <li>Run using PowerShell and the command, <u>java GCDFinder &lt;integer&gt;, &lt;integer&gt;</u>.</li>
</ol>

The core of GCDFinder converts an array of integers into an array of magnitudes, applies the "Modern Euclidean Algorithm" to the array of magnitudes, and finds the largest element of the array resulting from the algorithm. The source of "The Modern Euclidean Algorithm" is

Knuth, Donald E. (1998). "4.5.2. The Greatest Common Divisor". The Art of Computer Programming, Volume 2, Seminumerical Algorithms, Third Edition.

