package tugas.catur.lazuardykhatulistiwa;

public class Raja extends BidakCatur {
	
	public Raja(String warna, String lokasi, PapanCatur papan) {
		super(warna, lokasi, papan);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean gerakin(String tujuan) {
		// TODO Auto-generated method stub
		String lokasiawal = super.getLokasi();
		String lokasiakhir = tujuan;
		int barisawal = super.getBaris(lokasiawal);
		int baristujuan = super.getBaris(lokasiakhir);
		int kolomawal = super.getKolom(lokasiawal);
		int kolomtujuan = super.getKolom(lokasiakhir);
		int selisihbaris = Math.abs(barisawal - baristujuan);
		int selisihkolom = Math.abs(kolomawal - kolomtujuan);
		
		if ( (baristujuan > 8) || (baristujuan < 1) || (kolomtujuan > 8) || (kolomtujuan < 1) ) {
			System.out.println("Mentok cuy!");
			return false;
	
		} else if ( selisihbaris == 1 ) {
			if ( selisihkolom == 1 ) {
				super.setLokasi(tujuan);
				System.out.println("Raja berhasil pindah!");
				super.sudahGerak();
				return true;
			} else if (kolomawal == kolomtujuan) {
				super.setLokasi(tujuan);
				System.out.println("Raja berhasil pindah!");
				super.sudahGerak();
				return true;
			} else {
				System.out.println("Gagal pindah!");
				return false;
			}
			
		} else if ( selisihkolom == 1 ) {
			if ( selisihbaris == 1 ) {
				super.setLokasi(tujuan);
				System.out.println("Raja berhasil pindah!");
				super.sudahGerak();
				return true;
			} else if (barisawal == baristujuan) {
				super.setLokasi(tujuan);
				System.out.println("Raja berhasil pindah!");
				super.sudahGerak();
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
