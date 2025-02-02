// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

public class MatrixZeroOne {
	    public int[][] updateMatrix(int[][] matrix) {
	        if(matrix == null || matrix.length == 0) return matrix;
	        Queue<Integer> r = new LinkedList<>();
	        Queue<Integer> c = new LinkedList<>();
	        int m = matrix.length;
	        int n = matrix[0].length;
	        for(int i = 0 ; i< m ; i++){
	            for(int j = 0 ; j < n ; j++){     
	                if(matrix[i][j] == 0){
	                    r.add(i);
	                    c.add(j);
	                }else{
	                    matrix[i][j] = -1;
	                }
	            }
	        }
	        int dist = 1;
	        int[][] dirs = new int [][] {{0,1},{0,-1},{-1,0},{1,0}};
	        while (!r.isEmpty()){
	            int size = r.size();
	            for (int i = 0; i < size; i++){
	                int cr = r.poll();
	                int cc = c.poll();
	                for(int [] dir : dirs){
	                    int nr = cr + dir[0];
	                    int nc = cc + dir[1];
	                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1 ){
	                        r.add(nr);
	                        c.add(nc);
	                        matrix[nr][nc] = dist;
	                    }
	                }
	            }
	            
	           dist++; 
	            
	        }
	        
	        
	    return matrix;
	    }
	}