public class Decryption {

	

	public static int[] decryption(int[] cipherText, int[] key) {
		int[] permutacioniIp = Encryption.permutacioniIP(cipherText);
		int[] rightpart = Encryption.rightPart1(permutacioniIp);
		int[] leftpart = Encryption.leftPart1(permutacioniIp);
		int[] concatenation1 = Encryption.concatenate1(rightpart, rightpart);
		int[] permutacioniEp = Encryption.permutacioniEP(concatenation1);
		int[][] matrix1 = Encryption.matrix(permutacioniEp);
		int[][] matrixKey2 = Encryption.matrix(KeyGeneration.k2(key));
		int[][] matrixKey1 = Encryption.matrix(KeyGeneration.k1(key));
		int[][] xorM1 = Encryption.xOr_M(matrix1, matrixKey2);
		int[] extractp1 = Encryption.extractP(xorM1);
		int[] sbox1 = Encryption.s_box(extractp1);
		int[] xorV1 = Encryption.xOr_V(leftpart, sbox1);
		int[] concatenation2 = Encryption.concatenate1(xorV1, rightpart);
		int[] switchf = Encryption.switchFunction(concatenation2);

		int[] rightpartsf = Encryption.rightPart1(switchf);
		int[] leftpartsf = Encryption.leftPart1(switchf);
		int[] concatenation3 = Encryption
				.concatenate1(rightpartsf, rightpartsf);
		int[] permutacioniEp1 = Encryption.permutacioniEP(concatenation3);
		int[][] matrix2 = Encryption.matrix(permutacioniEp1);
		int[][] xorM2 = Encryption.xOr_M(matrix2, matrixKey1);
		int[] extractp2 = Encryption.extractP(xorM2);
		int[] sbox2 = Encryption.s_box(extractp2);
		int[] xorV2 = Encryption.xOr_V(leftpartsf, sbox2);
		int[] concatenation4 = Encryption.concatenate1(xorV2, rightpartsf);
		int[] plainT = Encryption.permutacioniIP_i(concatenation4);

		return plainT;

	}
}
