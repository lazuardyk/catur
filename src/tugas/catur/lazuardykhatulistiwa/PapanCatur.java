package tugas.catur.lazuardykhatulistiwa;

// class ini menggunakan metode komposisi
public class PapanCatur {
	private BidakCatur[][] papan = new BidakCatur[8][8]; // membuat papan dengan representasi array 2 dimensi
	
	// konstruktor untuk menambahkan bidak ke array 2 dimensi
	public PapanCatur() {
		papan[7][0] = new Benteng("H", "A8", this);
		papan[7][1] = new Kuda("H", "B8", this);
		papan[7][2] = new Kuncur("H", "C8", this);
		papan[7][3] = new Ratu("H","D8", this);
		papan[7][4] = new Raja("H", "E8", this);
		papan[7][5] = new Kuncur("H", "F8", this);
		papan[7][6] = new Kuda("H", "G8", this);
		papan[7][7] = new Benteng("H", "H8", this);
		
		char lokpion = 'A';
		for (int i = 0; i <= 7; i++) {
			String a = "7";
			String gabung = lokpion + a;
			papan[6][i] = new Pion("H", gabung, this);
			lokpion += 1;
		}
		
		papan[0][0] = new Benteng("P", "A1", this);
		papan[0][1] = new Kuda("P", "B1", this);
		papan[0][2] = new Kuncur("P", "C1", this);
		papan[0][3] = new Ratu("P","D1", this);
		papan[0][4] = new Raja("P", "E1", this);
		papan[0][5] = new Kuncur("P", "F1", this);
		papan[0][6] = new Kuda("P", "G1",this);
		papan[0][7] = new Benteng("P", "H1",this);
		
		char lokpion2 = 'A';
		for (int i = 0; i <= 7; i++) {
			String a = "2";
			String gabung = lokpion2 + a;
			papan[1][i] = new Pion("P", gabung, this);
			lokpion2 += 1;
		}
	}
	
	// untuk menampilkan papan
	public void viewPapan() {
		for (int i = 7; i >= 0;i--) {
			if (i == 7) {
				System.out.println("-----------------------------------------------------------");
			}
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					System.out.print("| ");
				}
				if (papan[i][j] instanceof Benteng) {
					if (papan[i][j].getWarna() == "H") {
						System.out.print("BenH");
					} else {
						System.out.print("BenP");
					}
				} else if (papan[i][j] instanceof Kuda) {
					if (papan[i][j].getWarna() == "H") {
						System.out.print("KudH");
					} else {
						System.out.print("KudP");
					}
				} else if (papan[i][j] instanceof Kuncur) {
					if (papan[i][j].getWarna() == "H") {
						System.out.print("KunH");
					} else {
						System.out.print("KunP");
					}
				} else if (papan[i][j] instanceof Ratu) {
					if (papan[i][j].getWarna() == "H") {
						System.out.print("RatH");
					} else {
						System.out.print("RatP");
					}
				} else if (papan[i][j] instanceof Raja) {
					if (papan[i][j].getWarna() == "H") {
						System.out.print("RajH");
					} else {
						System.out.print("RajP");
					}
				} else if (papan[i][j] instanceof Pion) {
					if (papan[i][j].getWarna() == "H") {
						System.out.print("PioH");
					} else {
						System.out.print("PioP");
					}
				} else {
					System.out.print("    ");
				}
				System.out.print(" | ");
				if (j == 7) {
					System.out.print(i + 1);
				}
			}
			System.out.println();
			System.out.println("-----------------------------------------------------------");
		}
		System.out.println("   a      b      c      d      e      f      g      h");
	}
	
	// untuk mengeluarkan papan dari class yang akan dipakai bidak
	public BidakCatur[][] getBidak() {
		return papan;
	}
	
	//untuk mengconvert posisi ke integer (ex: "E6" menjadi 65 (baris, kolom))
	public int posisitoInt(String posisi) {
		String lokasi = posisi;
		int a1 = (int) ((lokasi.charAt(0) - 'A') + 1);
		String a = Integer.toString(a1);
		char b1 = lokasi.charAt(1);
		int b11 = Character.getNumericValue(b1);
		int b12 = b11;
		String b = Integer.toString(b12);
		String ab = b + a;
		int loknumber = Integer.parseInt(ab);
		return loknumber;
	}	
	
	// untuk mengecek apakah user memakai bidak nya sendiri / tidak
	public boolean checkPermission(String lokawal, String warna) {
		int barisawal = this.getBaris(lokawal);
		int kolomawal = this.getKolom(lokawal);

		if (papan[barisawal - 1][kolomawal -1] != null) {
			if (papan[barisawal - 1][kolomawal -1].getWarna() == warna) {
				return true;
			} else {
				System.out.println("Anda harus menggerakan bidak anda sendiri!");
				System.out.println();
				return false;
			}
		} else {
			System.out.println("Anda menggerakan bidak kosong!");
			System.out.println();
			return false;
		}
		
		
	}
	
	// menconvert posisi ke integer(barisnya) (ex: "E2" menjadi 2)
	public int getBaris(String posisi) {
		int ab1 = this.posisitoInt(posisi);
		String ab = String.valueOf(ab1);
		char a1 = ab.charAt(0);
		int a = Character.getNumericValue(a1);
		return a;
	}
	
	// menconvert posisi ke integer(kolomnya) (ex: "E2" menjadi 6)
	public int getKolom(String posisi) {
		int ab1 = this.posisitoInt(posisi);
		String ab = String.valueOf(ab1);
		char a1 = ab.charAt(1);
		int a = Character.getNumericValue(a1);
		return a;
	}
	
	// untuk mengecek apakah raja masih hidup / tidak
	public int cekMenang() {
		// menang = 1 untuk hitam
		// menang = 2 untuk putih
		// menang = 0 blm ada yg menang
		
		int menang = 0;
		int putih = 0;
		int hitam = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (papan[i][j] instanceof Raja) {
					if (papan[i][j].getWarna() == "P") {
						putih = 1;
					} else if (papan[i][j].getWarna() == "H") {
						hitam = 1;
					}
				}
			}
		}
		if ( (hitam == 0) && (putih == 1) ){
			menang = 2;
			return menang;
		} else if ( (hitam == 1) && (putih == 0) ){
			menang = 1;
			return menang;
		} else {
			menang = 0;
			return menang;
		}
		
	}
	
	//untuk menggerakan raja ke tempat yg aman (rokade)
	private boolean rokade(String warna, String awal, String akhir) {
		int lokawalbaris = this.getBaris(awal);
		int lokawalkolom = this.getKolom(awal);
		int loktujuanbar = this.getBaris(akhir);
		int loktujuankol = this.getKolom(akhir);
		
		if (warna == "P") {
			if ( (papan[lokawalbaris - 1][lokawalkolom - 1] instanceof Raja) && (papan[lokawalbaris - 1][lokawalkolom - 1].isGerak() == 0) )  {
				if ( (papan[loktujuanbar - 1][loktujuankol - 1] == null ) && (papan[0][7] != null) ) {
					if ( (akhir.equals("G1")) && (papan[0][7] instanceof Benteng) && (papan[0][7].isGerak() == 0) ) {
						if ( (papan[0][5] == null) && (papan[0][6] == null) ) {
							papan[0][6] = papan[lokawalbaris - 1][lokawalkolom - 1];
							papan[lokawalbaris - 1][lokawalkolom - 1] = null;
							papan[0][5] = papan[0][7];
							papan[0][7] = null;
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			if ( (papan[lokawalbaris - 1][lokawalkolom - 1] instanceof Raja) && (papan[lokawalbaris - 1][lokawalkolom - 1].isGerak() == 0) )  {
				if ( (papan[loktujuanbar - 1][loktujuankol - 1] == null ) && (papan[7][7] != null) ) {
					if ( (akhir.equals("G8")) && (papan[7][7] instanceof Benteng) && (papan[7][7].isGerak() == 0) ) {
						if ( (papan[7][5] == null) && (papan[7][6] == null) ) {
							papan[7][6] = papan[lokawalbaris - 1][lokawalkolom - 1];
							papan[lokawalbaris - 1][lokawalkolom - 1] = null;
							papan[7][5] = papan[7][7];
							papan[7][7] = null;
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
	}
	
	
	//untuk memeriksa apakah input untuk pergerakan bidak valid / tidak
	public boolean pindahin (String awal, String akhir) {
		int lokawalbaris = this.getBaris(awal);
		int lokawalkolom = this.getKolom(awal);
		int loktujuanbar = this.getBaris(akhir);
		int loktujuankol = this.getKolom(akhir);
		int selisihkolom = Math.abs(lokawalkolom - loktujuankol);
		
		
		if (papan[lokawalbaris - 1][lokawalkolom - 1] != null) {
			if (papan[loktujuanbar - 1][loktujuankol - 1] != null) {
				if (papan[lokawalbaris - 1][lokawalkolom - 1].getWarna() == papan[loktujuanbar - 1][loktujuankol - 1].getWarna()) {
						System.out.println("Tidak bisa memakan bidak sendiri!");
						return false;
				} else if (papan[lokawalbaris - 1][lokawalkolom - 1].gerakin(akhir)) {
					if (papan[lokawalbaris - 1][lokawalkolom - 1] instanceof Pion) { // pion berubah jadi ratu jika diujung baris
						if (papan[lokawalbaris - 1][lokawalkolom - 1].getWarna() == "P" ) {
							if (loktujuanbar == 8) {
								papan[loktujuanbar - 1][loktujuankol - 1] = new Ratu ("P", awal, this);
								papan[lokawalbaris - 1][lokawalkolom - 1] = null;
								return true;
							}
						} else {
							if (loktujuanbar == 1) {
								papan[loktujuanbar - 1][loktujuankol - 1] = new Ratu ("P", awal, this);
								papan[lokawalbaris - 1][lokawalkolom - 1] = null;
								return true;
							}
						}
					}
					papan[loktujuanbar - 1][loktujuankol - 1] = papan[lokawalbaris - 1][lokawalkolom - 1];
					papan[lokawalbaris - 1][lokawalkolom - 1] = null;
					return true;
				} else {
					return false;
				}
			} else {
				if ( (papan[lokawalbaris - 1][lokawalkolom - 1] instanceof Raja) && (lokawalbaris == loktujuanbar) ) {
					if ( selisihkolom == 2 ) {
						if ( rokade( papan[lokawalbaris - 1][lokawalkolom - 1].getWarna(), awal , akhir )) {
							System.out.println("Rokade berhasil!");
							return true;
						} else {
							System.out.println("Rokade gagal!");
							return false;
						}
					} else {
						if (papan[lokawalbaris - 1][lokawalkolom - 1].gerakin(akhir)) {
							papan[loktujuanbar - 1][loktujuankol - 1] = papan[lokawalbaris - 1][lokawalkolom - 1];
							papan[lokawalbaris - 1][lokawalkolom - 1] = null;
							return true;
						} else {
							return false;
						}
					}
					
				} else {
					if (papan[lokawalbaris - 1][lokawalkolom - 1].gerakin(akhir)) {
						if (papan[lokawalbaris - 1][lokawalkolom - 1] instanceof Pion) { // pion berubah jadi ratu jika diujung baris
							if (papan[lokawalbaris - 1][lokawalkolom - 1].getWarna() == "P" ) {
								if (loktujuanbar == 8) {
									papan[loktujuanbar - 1][loktujuankol - 1] = new Ratu ("P", awal, this);
									papan[lokawalbaris - 1][lokawalkolom - 1] = null;
									return true;
								}
							} else {
								if (loktujuanbar == 1) {
									papan[loktujuanbar - 1][loktujuankol - 1] = new Ratu ("P", awal, this);
									papan[lokawalbaris - 1][lokawalkolom - 1] = null;
									return true;
								}
							}
						}
						papan[loktujuanbar - 1][loktujuankol - 1] = papan[lokawalbaris - 1][lokawalkolom - 1];
						papan[lokawalbaris - 1][lokawalkolom - 1] = null;
						return true;
					} else {
						return false;
					}
				}
			}
		} else {
			System.out.println("Bidak tidak ada!");
			return false;
		}
	}
	
}
