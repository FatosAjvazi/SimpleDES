import javax.swing.JOptionPane;

public class StartDES {
	public static char karakteri(int[] numri) {
		int nr = 0;

		for (int i = 0; i != 8; i++) {
			nr = nr + numri[i] * (int) Math.pow(2, 7 - i);
			}
		char karakter = (char) nr;

		return karakter;
	}

	public static void main(String args[]) {

		String input = JOptionPane
				.showInputDialog("Shtypeni E(per enkriptim),D(per dekriptim)");

		String upperCase = input.toUpperCase();

		if (upperCase.equals("E")) {
			String inputKey = JOptionPane
					.showInputDialog("Jepeni qelesin(numer binar 10 shifror):");
			int[] key = new int[10];
			for (int i = 0; i != 10; i++) {
				key[i] = (int) (inputKey.charAt(i) - 48);
			}
			String text = JOptionPane
					.showInputDialog("Shtype tekstin per enkriptim:");
			int[] text1 = new int[text.length() * 8];
			System.out.println("Mesazhi i enkriptuar per " + text + " eshte:");
			for (int i = 0; i != text.length(); i++) {
				text1 = Encryption.bajt_Ne_Bit(text.charAt(i));
				int[] t=Encryption.encryption(text1, key);
				System.out.print(karakteri(t));
			}

		} else if (upperCase.equals("D")) {
			String inputKey = JOptionPane
					.showInputDialog("Jepeni qelesin(numer binar 10 shifror)");
			int[] key = new int[10];
			for (int i = 0; i != 10; i++) {
				key[i] = (int) (inputKey.charAt(i) - 48);
			}
			String ciphertext = JOptionPane
					.showInputDialog("Shtype tekstin per dekriptim:");
			int[] text1 = new int[ciphertext.length()];
			System.out.println("Mesazhi idekriptuar per kodin " + ciphertext
					+ ", eshte:");
			for (int i = 0; i != ciphertext.length(); i++) {
				text1 = Encryption.bajt_Ne_Bit(ciphertext.charAt(i));
				int[] tekst2 = Decryption.decryption(text1, key);
				System.out.print(karakteri(tekst2));
			}

		} else {
			JOptionPane.showMessageDialog(null, "Keni shtypur hyrje gabim!!!");
			System.exit(0);
		}
	}
}
