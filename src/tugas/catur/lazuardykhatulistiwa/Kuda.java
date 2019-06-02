package tugas.catur.lazuardykhatulistiwa;

public class Kuda extends BidakCatur {

	public Kuda(String warna, String lokasi, PapanCatur papan) {
		super(warna, lokasi, papan);
		// TODO Auto-generated constructor stub
	}

	@Override
	// misal A7 -> C8
	public boolean gerakin(String tujuan) {
		String lokasiawal = super.getLokasi();
		String lokasiakhir = tujuan;
		int barisawal = super.getBaris(lokasiawal);
		int baristujuan = super.getBaris(lokasiakhir);
		int kolomawal = super.getKolom(lokasiawal);
		int kolomtujuan = super.getKolom(lokasiakhir);
		
		if ( (baristujuan > 8) || (baristujuan < 1) || (kolomtujuan > 8) || (kolomtujuan < 1) ) {
			System.out.println("Mentok cuy!");
			return false;
		} else if ( Math.abs(barisawal - baristujuan) == 1 ) {
			if ( Math.abs(kolomawal - kolomtujuan) == 2 ){
				super.setLokasi(tujuan);
				System.out.println("Kuda berhasil pindah!");
				return true;
			}
			System.out.println("Kuda gagal pindah!");
			return false;
		} else if ( Math.abs(kolomawal - kolomtujuan) == 1 ){
			if ( Math.abs(barisawal - baristujuan) == 2 ) {
				super.setLokasi(tujuan);
				System.out.println("Kuda berhasil pindah!");
				return true;
			}
			System.out.println("Kuda gagal pindah");
			return false;
		} else {
			System.out.println("Kuda harus jalan L bosqu!");
			return false;
		}
	}

}
