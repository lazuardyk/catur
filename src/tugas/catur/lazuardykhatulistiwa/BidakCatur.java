package tugas.catur.lazuardykhatulistiwa;

abstract public class BidakCatur {
	private String warna;
	private String loksaatini;
	private PapanCatur papan;
	private int gerak = 0; // field yang dipakai untuk menandakan Benteng & Raja udah gerak atau belum. Untuk keperluan Rokade.
	
	public BidakCatur(String warna, String lokasi, PapanCatur papan) {
		this.warna = warna;
		this.loksaatini = lokasi;
		this.papan = papan;
	}
	
	abstract public boolean gerakin(String tujuan);
	
	public String getWarna() {
		return this.warna;
	}
	
	public String getLokasi() {
		return this.loksaatini;
	}
	
	public void setLokasi(String lokasi) {
		this.loksaatini = lokasi;
	}
	
	protected BidakCatur[][] getBidak() {
		return this.papan.getBidak();
	}
	
	protected void sudahGerak() {
		this.gerak = 1;
	}
	
	public int isGerak() {
		return this.gerak;
	}
	
	//untuk mengconvert posisi ke integer (ex: "E6" menjadi 65 (baris, kolom))
	protected int posisitoInt(String posisi) {
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
	 
	//menconvert posisi ke integer(barisnya) (ex: "E2" menjadi 2)
	protected int getBaris(String posisi) {
		int ab1 = this.posisitoInt(posisi);
		String ab = String.valueOf(ab1);
		char a1 = ab.charAt(0);
		int a = Character.getNumericValue(a1);
		return a;
	}
	
	//menconvert posisi ke integer(kolomnya) (ex: "E2" menjadi 6)
	protected int getKolom(String posisi) {
		int ab1 = this.posisitoInt(posisi);
		String ab = String.valueOf(ab1);
		char a1 = ab.charAt(1);
		int a = Character.getNumericValue(a1);
		return a;
	}
	
}
