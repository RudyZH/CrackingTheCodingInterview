	public int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >> 1)) | (((x & 0x55555555) << 1));
	}
	
  01011011
0 0 1 1
 1 1 0 1
 
1 1 0 1
 0 0 1 1 
10100111
