package com.hwk.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
	
	
	}

	class ReturnData{
		int target;
		List<Integer> list ;
		
		 ReturnData(int target,List<Integer> list){
			this.list = list;
			this.target = target;
		}
	}
	
	public  List<List<Integer>> combinationSumdp(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		
		ReturnData[][] dp = new ReturnData[candidates.length][target];
		
		for(int i = 0;i<candidates.length;i++) {
			List<Integer> curlist = new ArrayList<>();
			curlist.add(candidates[i]);
			ReturnData data = new ReturnData(candidates[i], curlist);
			dp[i][0] = data;
		}
		
		return list;
	}
	

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();

		setCombinationSum(list, new ArrayList<>(), candidates, 0, target);

		return list;
	}

	private static void setCombinationSum(List<List<Integer>> list, List<Integer> curlist, int[] candidates, int target,
			int sum) {
		if (sum == target) {
			curlist.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer stu1, Integer stu2) {
					//以下如果改变顺序则调换一下参数位置
					return stu1 - stu2;
				}
			});
			if(!list.contains(curlist))
				list.add(curlist);
		} else if (sum < target) {
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			List<Integer> cur = new ArrayList<>(curlist);
			cur.add(candidates[i]);
			setCombinationSum(list, cur, candidates, target, sum - candidates[i]);
		}

	}

}
