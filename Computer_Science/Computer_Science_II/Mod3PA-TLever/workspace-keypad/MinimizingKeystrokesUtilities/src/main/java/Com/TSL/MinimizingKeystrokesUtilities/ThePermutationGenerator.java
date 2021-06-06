package Com.TSL.MinimizingKeystrokesUtilities;


import java.util.ArrayList;


class ThePermutationGenerator
{
	
	static ArrayList<ArrayList<Integer>> permute(int[] nums)
	{
		ArrayList<ArrayList<Integer>> bigList = new ArrayList<ArrayList<Integer>>();
		permute(nums, 0, bigList);
		return bigList;
	}

	static private void permute(int[] nums, int index, ArrayList<ArrayList<Integer>> bigList)
	{
		if (index == nums.length) {
			ArrayList l = new ArrayList(nums.length);
			for (int num : nums)
				l.add(num);
			bigList.add(l);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, i, index);
			permute(nums, index + 1, bigList);
			swap(nums, i, index);
		}
	}

	private static void swap(int[] nums, int i, int index)
	{
		int temp = nums[i];
		nums[i] = nums[index];
		nums[index] = temp;
	}
    
}