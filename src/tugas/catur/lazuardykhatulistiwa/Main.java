package tugas.catur.lazuardykhatulistiwa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int giliran = 1;
		String keluar = "Q";
		
		Scanner keyboard = new Scanner(System.in);
		PapanCatur papan = new PapanCatur();
		
		System.out.println("Selamat datang di Permainan Catur!");
		System.out.println("Keterangan:\n- Ben adalah Benteng\n- Kud adalah Kuda\n- Kun adalah Kuncur\n- Rat adalah Ratu\n- Raj adalah Raja\n- Pio adalah Pion\n- H berarti Hitam, P berarti Putih\n");
		while(true) {
			int menang = papan.cekMenang();
			if ( menang == 1 ) {
				System.out.println("Congratulations! Hitam menang!");
				break;
			} else if ( menang == 2 ) {
				System.out.println("Congratulations! Putih menang!");
				break;
			}
			
			if (giliran == 1) {
				papan.viewPapan();
				System.out.println();
				System.out.println("Putih silahkan jalan: (format input: lokasi awal, lokasi akhir. ex: d3 d5) / ketik q untuk keluar");
				String jawab = keyboard.nextLine();
				String[] arr = jawab.split(" ");
				if ( arr[0].toUpperCase().equals(keluar) ) {
					System.out.println("Putih keluar dari permainan, Hitam menang!");
					break;
				} else if (arr.length == 2) {
					if ( (arr[0].length() == 2) && (arr[1].length() == 2) ) {
						if (papan.checkPermission(arr[0].toUpperCase(), "P")) {
							if ( papan.pindahin(arr[0].toUpperCase(), arr[1].toUpperCase()) ){
								System.out.println();
								giliran = 2;
							} else {
								System.out.println();
								continue;
							}
						} else {
							continue;
						}
					} else {
						System.out.println("Input salah!");
					}
				} else {
					System.out.println("Input salah!");
				}
				
			} else {
				papan.viewPapan();
				System.out.println();
				System.out.println("Hitam silahkan jalan: (format input: lokasi awal, lokasi akhir. ex: d3 d5) / ketik q untuk keluar");
				String jawab = keyboard.nextLine();
				String[] arr = jawab.split(" ");
				if ( arr[0].toUpperCase().equals(keluar) ) {
					System.out.println("Hitam keluar dari permainan, Putih menang!");
					break;
				} else if (arr.length == 2) {
					if ( (arr[0].length() == 2) && (arr[1].length() == 2) ) {
						if (papan.checkPermission(arr[0].toUpperCase(), "H")) {
							if ( papan.pindahin(arr[0].toUpperCase(), arr[1].toUpperCase()) ){
								System.out.println();
								giliran = 1;
							} else {
								System.out.println();
								continue;
							}
						} else {
							continue;
						}
					} else {
						System.out.println("Input salah!");
					}
				} else {
					System.out.println("Input salah!");
				}
			}
		}
		keyboard.close();
	}

}
