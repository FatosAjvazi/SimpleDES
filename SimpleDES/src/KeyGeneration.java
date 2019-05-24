/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class KeyGeneration {
	public static int[] permutacioni10(int[] key) // kryen permutacionin e
													// nevojshem te qelesit
	{
		int[] rezultati = new int[10];

		rezultati[0] = key[2];
		rezultati[1] = key[4];
		rezultati[2] = key[1];
		rezultati[3] = key[6];
		rezultati[4] = key[3];
		rezultati[5] = key[9];
		rezultati[6] = key[0];
		rezultati[7] = key[8];
		rezultati[8] = key[7];
		rezultati[9] = key[5];

		return rezultati;
	}

	public static int[] leftPart(int[] p10key) // kthen ndarjen e majt te
												// qelesit
	{
		int[] lpart = new int[5];
		for (int i = 0; i != 5; i++) {
			lpart[i] = p10key[i];
		}
		return lpart;
	}

	public static int[] rightPart(int[] p10key) // kthen ndarjen e djatht te
												// qelesit
	{
		int[] rpart = new int[5];
		for (int i = 0; i != 5; i++) {
			rpart[i] = p10key[i + 5];
		}
		return rpart;
	}

	public static int[] shift(int[] a, int n) {
		int[] shifted = new int[5];
		for (int i = 0; i != 5; i++) {
			shifted[i] = a[(i + n) % 5];

		}
		return shifted;
	}

	public static int[] concatenate(int[] shL, int[] shR) {
		int[] conc = new int[10];
		for (int i = 0; i != conc.length; i++) {

			if (i >= 5) {
				conc[i] = shR[i - 5];
			} else {
				conc[i] = shL[i];
			}
		}

		return conc;
	}

	public static int[] permutacioni8(int[] cnc) {
		int[] K1 = new int[8];
		K1[0] = cnc[5];
		K1[1] = cnc[2];
		K1[2] = cnc[6];
		K1[3] = cnc[3];
		K1[4] = cnc[7];
		K1[5] = cnc[4];
		K1[6] = cnc[9];
		K1[7] = cnc[8];

		return K1;

	}

	public static int[] k1(int[] key) {
		int[] k_p = permutacioni10(key);
		int[] l_p = leftPart(k_p);
		int[] r_p = rightPart(k_p);
		int[] sh_rp = shift(r_p, 1);
		int[] sh_lp = shift(l_p, 1);
		int[] c_k = concatenate(sh_lp, sh_rp);
		int[] k1 = permutacioni8(c_k);
		// for(int i =0;i!=8;i++){System.out.print(k1[i]);}
		return k1;
	}

	public static int[] k2(int[] key) {
		int[] k_p = permutacioni10(key);
		int[] l_p = leftPart(k_p);
		int[] r_p = rightPart(k_p);
		int[] sh_rp = shift(r_p, 1);
		int[] sh_lp = shift(l_p, 1);
		int[] c_k = concatenate(sh_lp, sh_rp);
		int[] l_k = leftPart(c_k);
		int[] r_k = rightPart(c_k);
		int[] sh_lk = shift(l_k, 2);
		int[] sh_rk = shift(r_k, 2);
		int[] c_sh = concatenate(sh_lk, sh_rk);
		int[] k2 = permutacioni8(c_sh);
		// for(int i =0;i!=8;i++){System.out.print(k2[i]);}
		return k2;
	}

}
