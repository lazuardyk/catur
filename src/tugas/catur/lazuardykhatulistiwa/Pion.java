package tugas.catur.lazuardykhatulistiwa;

public class Pion extends BidakCatur {

	public Pion(String warna, String lokasi, PapanCatur papan) {
		super(warna, lokasi, papan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean gerakin(String tujuan) {
		BidakCatur[][] bidak = super.getBidak();
		// TODO Auto-generated method stub
		String lokasiawal = super.getLokasi();
		String lokasiakhir = tujuan;
		int barisawal = super.getBaris(lokasiawal);
		int baristujuan = super.getBaris(lokasiakhir);
		int kolomawal = super.getKolom(lokasiawal);
		int kolomtujuan = super.getKolom(lokasiakhir);
		int selisihkolom = Math.abs(kolomawal - kolomtujuan);
		
		if ( (baristujuan > 8) || (baristujuan < 1) || (kolomtujuan > 8) || (kolomtujuan < 1) ) {
			System.out.println("Mentok cuy!");
			return false;
		} else if (kolomawal == kolomtujuan) {
			if ( (barisawal == 2) || (barisawal == 7) ) {
				if ( (Math.abs(barisawal - baristujuan) == 1) || (Math.abs(barisawal - baristujuan) == 2) ) {
					super.setLokasi(tujuan);
					System.out.println("Pion berhasil pindah!");
					return true;
				} else {
					System.out.println("Gagal pindah!");
					return false;
				}
			} else {
				if (Math.abs(barisawal - baristujuan) == 1) {
					if (bidak[barisawal - 1][kolomawal - 1].getWarna() == "P") {
						if (barisawal < baristujuan) {
							int tabrakan = 0;
							if (bidak[barisawal - 1 + 1][kolomawal - 1] != null ) {
								tabrakan = 1;
								System.out.println("Pion nabrak bidak!");
							}
							if (tabrakan == 0) {
								super.setLokasi(tujuan);
								System.out.println("Pion berhasil pindah!");
								return true;
							} else {
								System.out.println("Gagal pindah!");
								return false;
							}
						} else {
							System.out.println("Gagal pindah!");
							return false;
						}
					} else {
						if (barisawal > baristujuan) {
							int tabrakan = 0;
							if (bidak[barisawal - 1 + 1][kolomawal - 1] != null ) {
								tabrakan = 1;
								System.out.println("Pion nabrak bidak!");
							}
							if (tabrakan == 0) {
								super.setLokasi(tujuan);
								System.out.println("Pion berhasil pindah!");
								return true;
							} else {
								System.out.println("Gagal pindah!");
								return false;
							}
						} else {
							System.out.println("Gagal pindah!");
							return false;
						}
					}					
				}
				System.out.println("Gagal pindah!");
				return false;
			}
		} else {
			if (selisihkolom == 1) {
				if (bidak[barisawal - 1][kolomawal - 1].getWarna() != bidak[baristujuan - 1][kolomtujuan - 1].getWarna()) {
					super.setLokasi(tujuan);
					System.out.println("Pion berhasil pindah!");
					return true;
				} else {
					System.out.println("Gagal pindah!");
					return false;
				}
			} else {
				System.out.println("Gagal pindah!");
				return false;
			}
		}
	}
}
