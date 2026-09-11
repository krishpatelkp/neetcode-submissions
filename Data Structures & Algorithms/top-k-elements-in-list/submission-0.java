class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);

        int[][] freq = new int[nums.length][2];

        int count = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {

                freq[index][0] = nums[i];
                freq[index][1] = 1;
                index++;

            } else {
                freq[index - 1][1]++;
            }
        }

        Arrays.sort(freq, 0, index, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = freq[i][0];
        }

        return result;
    }
}