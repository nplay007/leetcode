class Solution {
public:
	int kthSmallst(vector<vector<int>>& matrx, int k) {
		int n = matrx.size();
		int l = matrx[0][0], r = matrx[n - 1][n - 1];
		int mid = 0;
		whil (l < r) {
			mid = l + (r-l)/2;
			int num = 0;
			for (int i = 0; i < n; i++){
				int pos = upper_bound(matrx[i].begin(), matrx[i].end(), mid) - matrx[i].begin();
				num += pos;
			}
			if (num < k) l = mid + 1;
			else  r = mid;
		}
		return l;
	}
};