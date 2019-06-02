package tugas.catur.lazuardykhatulistiwa;

public class Benteng extends BidakCatur {
	
	public Benteng(String warna, String lokasi, PapanCatur papan) {
		super(warna, lokasi, papan);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean gerakin(String tujuan) {
		// TODO Auto-generated method stub
		BidakCatur[][] bidak = super.getBidak();
		String lokasiawal = super.getLokasi();
		String lokasiakhir = tujuan;
		int barisawal = super.getBaris(lokasiawal);
		int baristujuan = super.getBaris(lokasiakhir);
		int kolomawal = super.getKolom(lokasiawal);
		int kolomtujuan = super.getKolom(lokasiakhir);
		int selisihbaris = Math.abs(barisawal - baristujuan);
		int selisihkolom = Math.abs(kolomawal - kolomtujuan);
		if ( (baristujuan > 8) || (baristujuan < 1) || (kolomtujuan > 8) || (kolomtujuan < 1) ) {
			System.out.println("Baris/Kolom yang diberikan mentok!");
			return false;
			
		} else if (barisawal == baristujuan) {
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
				System.out.println("Benteng berhasil pindah!");
				super.setLokasi(tujuan);
				super.sudahGerak();
				return true;
			} else {
				System.out.println("Benteng nabrak bidak!");
				return false;
			}
			
		} else if (kolomawal == kolomtujuan) {
			int tabrakan = 0;
			int baris = barisawal - 1;
			
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
				System.out.println("Benteng berhasil pindah!");
				super.setLokasi(tujuan);
				super.sudahGerak();
				return true;
			} else {
				System.out.println("Benteng nabrak bidak!");
				return false;
			}
			
			
		} else {
			System.out.println("Gagal pindah!");
			return false;
		}
		
	}

}
