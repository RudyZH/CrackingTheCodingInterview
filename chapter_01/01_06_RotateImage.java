package 数组与字符串;

public class RotateImage {

	
	/*
	 *  method 1
	 *  镜像翻转
	 */
	public void rotateImage(char[][] image) {
		if (image == null || image.length <= 1)
			return;
		int row = image.length;
		int col = image[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < i; j++) {
				char c = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = c;
			}
		}
		for (int i = 0; i < row; i++) {
			reverse(image, i, col);
		}		
	}
	
	/*
	 *  method 2
	 *  逐层交换
	 *  最优解
	 */
	
	public void rotate(char[][] image, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				// 存储上边
				char top = image[first][i];
				// 左到上
				image[first][i] = image[last - offset][first];
				// 下到左
				image[last - offset][first] = image[last][last - offset];
				// 右到下
				image[last][last - offset] = image[i][last];
				// 上到右
				image[i][last] = top;
			}
		}
	}
	
	private void reverse(char[][] image, int row, int col) {
		int begin = 0, end = col - 1;
		while (begin < end) {
			char c = image[row][begin];
			image[row][begin] = image[row][end];
			image[row][end] = c;
			begin++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		RotateImage r = new RotateImage();
		char[][] image = {{'a', 'b', 'c', 'd'},
						   {'e', 'f', 'g', 'h'},
						   {'i', 'j', 'k', 'l'},
						   {'m', 'n', 'o', 'p'}};
		for (char[] row : image) {
			for (char col : row) 
				System.out.print(col + " ");
			System.out.println();
		}
		
		System.out.println();
		r.rotateImage(image);

		for (char[] row : image) {
			for (char col : row) 
				System.out.print(col + " ");
			System.out.println();
		}
		
		System.out.println();
		r.rotate(image, 4);

		for (char[] row : image) {
			for (char col : row) 
				System.out.print(col + " ");
			System.out.println();
		}
	}

}
