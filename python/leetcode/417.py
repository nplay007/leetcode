class Solution(object):
	def pacificAtlantic(self, matrix):
		def fill(ocean, stack):
			while stack:
				r,c = stack.pop()
				if (r,c) in ocean: continue
				ocean.add((r,c))
				stack.extend([
					[nr, nc] for nr, nc in [[r-1,c], [r+1,c], [r,c-1], [r,c+1]]
					if 0 <= nr < m and 0 <= nc < n and matrix[r][c] <= matrix[nr][nc]])
					
		if not matrix or not matrix[0]:	return []
		m, n = len(matrix), len(matrix[0])
		pacific, atlantic = set(), set()
		pstack = [[r,0] for r in xrange(m)] + [[0,c] for c in xrange(1,n)]
		astack = [[r,n-1] for r in xrange(m)] + [[m-1,c] for c in xrange(n-1)]
		fill(pacific, pstack)
		fill(atlantic, astack)
		return [list(x) for x in pacific&atlantic]