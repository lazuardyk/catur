package tugas.catur.lazuardykhatulistiwa;

public class Ratu extends BidakCatur {

	public Ratu(String warna, String lokasi, PapanCatur papan) {
		super(warna, lokasi, papan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean gerakin(String tujuan) {
		BidakCatur[][] bidak = super.getBidak();
		
		String lokasiawal = super.getLokasi();
		String lokasiakhir = tujuan;
		int barisawal = super.getBaris(lokasiawal);
		int baristujuan = super.getBaris(lokasiakhir);
		int kolomawal = super.getKolom(lokasiawal);
		int kolomtujuan = super.getKolom(lokasiakhir);
		
		// TODO Auto-generated method stub
		if ( (baristujuan > 8) || (baristujuan < 1) || (kolomtujuan > 8) || (kolomtujuan < 1) ) {
			System.out.println("Mentok cuy!");
			return false;
		} else if (barisawal == baristujuan) {
			int selisihkolom = Math.abs(kolomawal - kolomtujuan);
			int tabrakan = 0;
			int kolom = kolomawal - 1;
			
			while (selisihkolom-1 > 0) {
				if (kolomawal > kolomtujuan) {
					kolom -= 1;
				} else {
					kolom += 1;
				}
				if (bidak[barisawal - 1][kolom] != null) {
						tabrakan = 1;
						break;
				}
				selisihkolom -= 1;
			}
			if (tabrakan == 0) {
				System.out.println("Ratu berhasil pindah!");
				super.setLokasi(tujuan);
				return true;
			} else {
				System.out.println("Ratu nabrak bidak!");
				return false;
			}
			
		} else if (kolomawal == kolomtujuan) {
			int tabrakan = 0;
			int baris = barisawal - 1;
			int selisihbaris = Math.abs(barisawal - baristujuan);
			
			while (selisihbaris-1 > 0) {
				if (barisawal > baristujuan) {
					baris -= 1;
				} else {
					baris += 1;
				}
				if (bidak[baris][kolomawal - 1] != null) {
						tabrakan = 1;
						break;
				}
				selisihbaris -= 1;
			}
			if (tabrakan == 0) {
				System.out.println("Ratu berhasil pindah!");
				super.setLokasi(tujuan);
				return true;
			} else {
				System.out.println("Ratu nabrak bidak!");
				return false;
			}
		} else if ( Math.abs(barisawal - baristujuan) == Math.abs(kolomawal - kolomtujuan) ) {
			int tabrakan = 0;
			int baris = barisawal - 1;
			int kolom = kolomawal - 1;
			int selisihbaris = barisawal - baristujuan;
			int selisihkolom = kolomawal - kolomtujuan;
			
			if( (selisihbaris < 0) && (selisihkolom > 0) ){
				while (selisihkolom - 1 > 0) {
					baris += 1;
					kolom -= 1;
					
					if (bidak[baris][kolom] != null) {
						tabrakan = 1;
						break;
					}
					selisihkolom -= 1;
				}
			} else if ( (selisihbaris > 0) && (selisihkolom > 0) ) {
				while (selisihkolom - 1 > 0) {
					baris -= 1;
					kolom -= 1;
					
					if (bidak[baris][kolom] != null) {
						tabrakan = 1;
						break;
					}
					selisihkolom -= 1;
				}
			} else if ( (selisihbaris < 0) && (selisihkolom < 0) ) {
				selisihkolom = Math.abs(selisihkolom);
				while (selisihkolom - 1 > 0) {
					baris += 1;
					kolom += 1;
					
					if (bidak[baris][kolom] != null) {
						tabrakan = 1;
						break;
					}
					selisihkolom -= 1;
				}
			} else if ( (selisihbaris > 0) && (selisihkolom < 0) ) {
				while (selisihbaris - 1 > 0) {
					baris -= 1;
					kolom += 1;
					
					if (bidak[baris][kolom] != null) {
						tabrakan = 1;
						break;
					}
					selisihbaris -= 1;
				}
			}
			
			
			if (tabrakan == 0) {
				super.setLokasi(tujuan);
				System.out.println("Ratu berhasil pindah!");
				return true;
			} else {
				System.out.println("Ratu nabrak bidak!");
				return false;
			}
			
			
		} else {
			System.out.println("Gagal pindah!");
			return false;
		}
	}

}
