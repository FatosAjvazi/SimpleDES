public class Encryption {

	public static int[] bajt_Ne_Bit(char a) {
		int c = (int) a;
		int[] bits = new int[8];
		String b = Integer.toBinaryString(c);
		int x = b.length();
		for (int i = 0; i != (8 - x); i++) {
			b = 0 + b;
		}

		for (int i = 0; i != 8; i++) {
			bits[i] = new Integer(b.charAt(i) + "").intValue();
		}

		return bits;
	}

	public static int[] plaintext(String a) {
		int gj = a.length();
		byte[] b = a.getBytes();
		int[] bytes = new int[gj];
		for (int i = 0; i != gj; i++) {
			int z = (int) (b[i]);
			for (int j = 0; j != 8; j++) {
				bytes[j] = (z + "").charAt(j);
			}
		}
		return bytes;
	}

	public static int[] leftPart1(int[] p8key) // kthen ndarjen e majt te
	// qelesit
	{
		int[] lpart = new int[4];
		for (int i = 0; i != 4; i++) {
			lpart[i] = p8key[i];
		}
		return lpart;
	}

	public static int[] rightPart1(int[] p8key) // kthen ndarjen e djatht te
	// qelesit
	{
		int[] rpart = new int[4];
		for (int i = 0; i != 4; i++) {
			rpart[i] = p8key[i + 4];
		}
		return rpart;
	}

	public static int[] permutacioniIP(int[] a) {
		int[] IP = new int[a.length];
		IP[0] = a[1];
		IP[1] = a[5];
		IP[2] = a[2];
		IP[3] = a[0];
		IP[4] = a[3];
		IP[5] = a[7];
		IP[6] = a[4];
		IP[7] = a[6];
		return IP;
	}

	public static int[] permutacioniEP(int[] a) {
		int[] EP = new int[8];
		EP[0] = a[3];
		EP[1] = a[0];
		EP[2] = a[1];
		EP[3] = a[2];
		EP[4] = a[1];
		EP[5] = a[2];
		EP[6] = a[3];
		EP[7] = a[0];
		return EP;
	}

	public static int[][] matrix(int[] a) {
		int[][] mat = new int[2][4];
		for (int i = 0; i != 2; i++) {
			for (int j = 0; j != 4; j++) {
				mat[i][j] = a[j];
				if (i == 1) {
					mat[i][j] = a[j + 4];
				}
			}
		}
		return mat;
	}

	public static int[][] xOr_M(int[][] m1, int[][] m2) {
		int[][] m = new int[2][4];
		int[] n1 = new int[4];
		int[] n2 = new int[4];
		int[] n3 = new int[4];
		int[] n4 = new int[4];
		for (int i = 0; i != 2; i++) {
			for (int j = 0; j != 4; j++) {
				n1[j] = m1[i][j];
				n2[j] = m1[i][j];
				n3[j] = m2[i][j];
				n4[j] = m2[i][j];

				if (n1[j] == n3[j]) {
					m[i][j] = 0;
				} else {
					m[i][j] = 1;
				}
			}
		}

		return m;
	}

	public static int[] extractP(int[][] m) {
		String[] vargu = new String[4];
		int[] vargu1 = new int[4];
		vargu[0] = "" + m[0][1] + m[0][2];
		vargu[1] = "" + m[0][0] + m[0][3];
		vargu[2] = "" + m[1][1] + m[1][2];
		vargu[3] = "" + m[1][0] + m[1][3];
		// System.out.println(vargu[0]);
		for (int i = 0; i != 4; i++) {
			if (vargu[i].equals("00")) {
				vargu1[i] = 0;
			} else if (vargu[i].equals("01")) {
				vargu1[i] = 1;
			} else if (vargu[i].equals("10")) {
				vargu1[i] = 2;
			} else {
				vargu1[i] = 3;
			}
		}
		return vargu1;
	}

	public static int[] s_box(int[] vrg) {
		int[][] s0 = { { 1, 0, 3, 2 }, { 3, 2, 1, 0 }, { 0, 2, 1, 3 },
				{ 3, 1, 3, 2 } };
		int[][] s1 = { { 0, 1, 2, 3 }, { 2, 0, 1, 3 }, { 3, 0, 1, 0 },
				{ 2, 1, 0, 3 } };
		int[] b = new int[2];
		b[0] = s0[vrg[1]][vrg[0]];
		b[1] = s1[vrg[3]][vrg[2]];
		int[] box = new int[4];
		String zh = "";
		for (int i = 0; i != 2; i++) {
			if (b[i] == 0) {
				zh = zh + "00";
			}
			if (b[i] == 1) {
				zh = zh + "01";
			}
			if (b[i] == 2) {
				zh = zh + "10";
			}
			if (b[i] == 3) {
				zh = zh + "11";
			}

		}
		for (int i = 0; i != 4; i++) {
			box[i] = zh.charAt(i) - 48;
		}
		int[] box_p = new int[4];

		box_p[0] = box[1];
		box_p[1] = box[3];
		box_p[2] = box[2];
		box_p[3] = box[0];

		return box_p;
	}

	public static int[] xOr_V(int[] v1, int[] v2) {
		int[] v = new int[4];
		for (int i = 0; i != 4; i++) {
			if (v1[i] == v2[i]) {
				v[i] = 0;
			} else {
				v[i] = 1;
			}
		}
		return v;
	}

	public static int[] switchFunction(int[] k) {
		int[] sk = new int[8];
		for (int i = 0; i != 8; i++) {
			sk[i] = k[(i + 4) % 8];
		}
		return sk;
	}

	public static int[] permutacioniIP_i(int[] v) {
		int[] p = new int[8];
		p[0] = v[3];
		p[1] = v[0];
		p[2] = v[2];
		p[3] = v[4];
		p[4] = v[6];
		p[5] = v[1];
		p[6] = v[7];
		p[7] = v[5];
		return p;
	}

	public static int[] concatenate1(int[] shL, int[] shR) {
		int[] conc = new int[8];
		for (int i = 0; i != conc.length; i++) {

			if (i < 4) {
				conc[i] = shL[i];
			} else {
				conc[i] = shR[i - 4];
			}
		}

		return conc;
	}


	public  static int[] encryption(int[] plaintext, int[] key) {
		int[] permutacioniIp = permutacioniIP(plaintext);
		int[] leftpart = leftPart1(permutacioniIp);
		int[] rightpart = rightPart1(permutacioniIp);
		int[] concatenation = concatenate1(rightpart, rightpart);
		int[] permutacioniEp = permutacioniEP(concatenation);
		int[][] matrixEp = matrix(permutacioniEp);
		int[][] matrixKey1 = matrix(KeyGeneration.k1(key));
		int[][] matrixKey2 = matrix(KeyGeneration.k2(key));
		int[][] xor1 = xOr_M(matrixEp, matrixKey1);
		int[] extractp = extractP(xor1);
		int[] sbox = s_box(extractp);
		int[] xorv1 = xOr_V(sbox, leftpart);
		int[] concatenation1 = concatenate1(xorv1, rightpart);
		int[] switchf = switchFunction(concatenation1);

		int[] leftpart1 = leftPart1(switchf);
		int[] rightpart1 = rightPart1(switchf);
		int[] concatenation2 = concatenate1(rightpart1, rightpart1);
		int[] permutacioniEp1 = permutacioniEP(concatenation2);
		int[][] matrixEp1 = matrix(permutacioniEp1);

		int[][] xor2 = xOr_M(matrixEp1, matrixKey2);
		int[] extractp1 = extractP(xor2);

		int[] sbox1 = s_box(extractp1);
		int[] xorV2 = xOr_V(leftpart1, sbox1);
		int[] concatenation3 = concatenate1(xorV2, rightpart1);
		int[] permutacioniInvers = permutacioniIP_i(concatenation3);
		return permutacioniInvers;
		
	}
}
