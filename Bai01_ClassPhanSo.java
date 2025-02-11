
package phanso;

public class phanSo {

    private int tuSo; 
    private int mauSo;

    // Constructor
    public phanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so khong the bang 0"); // exception de dam bao chuong trinh van chay binh thuong khi loi va hien thi ra loi 
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        
        rutGon();
    }
    
    // Hien thi phan so 
    public void hienThiPhanSo() {
        System.out.print(this.tuSo + "/" + this.mauSo + '\n');
    }
    
    // Tim ucln 
        /** Cach tim: a = 12, b = 18
         * Step 1: du = 12%18 = 12, a = b = 18, b = du = 12
         * Step 2: du = 18%12 = 6, a = b = 12, b = 6
         * Step 3: du = 12%6 = 0, a = b = 6, b = 0
         * b = 0 -> dung, va ucln la a 
         */
    public int ucln(int a, int b) {
        while (b != 0) {
            int du = a % b;
            a = b; 
            b = du;
        }
        return Math.abs(a);
    }
    
    // Rut gon phan so 
    public void rutGon() {
        int gcd = ucln(this.tuSo, this.mauSo);
        
        this.tuSo /= gcd; 
        this.mauSo /= gcd;
        
        if (this.mauSo < 0) {
            this.tuSo = -this.tuSo; 
            this.mauSo = -this.mauSo;
        }
    }
    
    // Cong 2 phan so 
    public phanSo congPhanSo(phanSo ps) {
        int tuSoMoi = this.tuSo*ps.mauSo + ps.tuSo*this.mauSo;
        int mauSoMoi = this.mauSo*ps.mauSo; 
        
        return new phanSo(tuSoMoi, mauSoMoi);
    }
    
    // Tru 2 phan so 
    public phanSo truPhanSo(phanSo ps) {
        int tuSoMoi = this.tuSo*ps.mauSo - ps.tuSo*this.mauSo; 
        int mauSoMoi = this.mauSo*ps.mauSo; 
        
        return new phanSo(tuSoMoi, mauSoMoi);
    }
    
    // Nhan 2 phan so 
    public phanSo nhanPhanSo(phanSo ps) {
        int tuSoMoi = this.tuSo * ps.tuSo;
        int mauSoMoi = this.mauSo * ps.mauSo;
        
        return new phanSo(tuSoMoi, mauSoMoi);
    }
    
    // Chia 2 phan so 
    public phanSo chiaPhanSo(phanSo ps) {
        int tuSoMoi = this.tuSo * ps.mauSo;
        int mauSoMoi = this.mauSo * ps.tuSo;
        
        return new phanSo(tuSoMoi, mauSoMoi);
    }
    
    // So sanh 2 phan so 
    public void soSanhPhanSo(phanSo ps) {
        double ps1 = (double)this.tuSo / this.mauSo; 
        double ps2 = (double)ps.tuSo / ps.mauSo;
        
        if (ps1 > ps2) {
            System.out.print("Phan so " + this.tuSo + "/" + this.mauSo + " > Phan so " + ps.tuSo + "/" + ps.mauSo + "\n");
        } else if (ps1 < ps2) {
            System.out.print("Phan so " + this.tuSo + "/" + this.mauSo + " < Phan so " + ps.tuSo + "/" + ps.mauSo + "\n");
        } else {
            System.out.print("Phan so " + this.tuSo + "/" + this.mauSo + " = Phan so " + ps.tuSo + "/" + ps.mauSo + "\n");
        }
    }
    
    public static void main(String[] args) {
        phanSo ps1 = new phanSo(1, 2);        
        phanSo ps2 = new phanSo(2, 3);

        phanSo phanSoTong = ps1.congPhanSo(ps2);
        phanSo phanSoHieu = ps1.truPhanSo(ps2);
        phanSo phanSoTich = ps1.nhanPhanSo(ps2);
        phanSo phanSoThuong = ps1.chiaPhanSo(ps2);

        phanSoTong.hienThiPhanSo();        
        phanSoHieu.hienThiPhanSo();
        phanSoTich.hienThiPhanSo();
        phanSoThuong.hienThiPhanSo();
        ps1.soSanhPhanSo(ps2);
    }  
}
