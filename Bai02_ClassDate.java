
package bai02_classdate;

import java.util.Scanner;

public class Bai02_ClassDate {

    private int day; 
    private int month; 
    private int year; 
    
    // Constructor
    public Bai02_ClassDate() {
    }

    public Bai02_ClassDate(int day, int month, int year) {
        this.day = day;
        this.month = month; 
        this.year = year;
    }
    
    // Ham nhap ngay thang nam 
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay: ");
        this.day = sc.nextInt();
        System.out.print("Nhap thang: ");
        this.month = sc.nextInt();
        System.out.print("Nhap nam: ");
        this.year = sc.nextInt();
    }
    
    // Ham xuat ngay thang nam 
    public void output() {
        System.out.print(this.day + "/" + this.month + "/" + this.year + "\n");
    }
        
    // Ham tinh so ngay trong thang 
    public int dayInMonth() {
        int day = 0;
        
        switch (this.month) {
            case 4: 
            case 6: 
            case 9: 
            case 11: 
                day = 30; 
                break;
            case 2: 
                day = isLeapYear() ? 29 : 28;
                break;
            default: 
                day = 31;
                break;
        }
        
        return day;
    }
    
    // Ham kiem tra tinh hop le cua ngay thang nam 
    public boolean checkDate() {
        int day = dayInMonth();
        
        return (this.day >= 1 && this.day <= day) && (this.month >= 1 && this.month <= 12) && (this.year >= 1);
                
    }
    
    // Ham kiem tra nam nhuan 
    public boolean isLeapYear() {
        return (this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0);
    }
    
    // Ham xuat ngay thang nam theo dinh dang dd/mm/yyyy
    public void outputByFormat() {
        String date = "";
        
        if (this.day < 10) {
            date += "0" + this.day + "/";
        } else {
            date += this.day + "/";
        }
        
        if (this.month < 10) {
            date += "0" + this.month + "/";
        } else {
            date += this.month + "/";
        }
        
        date += this.year;
        
        System.out.println(date);
    }
    
    // Ham cong so ngay nhap tu ban phim 
    public Bai02_ClassDate addDate(int day) {                
        int newDay = this.day + day; 
        int newMonth = this.month; 
        int newYear = this.year;
        
        int dayInMonth = this.dayInMonth();
        
        while(true) {
            if (newDay <= dayInMonth) {
                break;
            } else {
                newDay -= dayInMonth;
                newMonth++;

                if (newMonth > 12) {
                    newMonth = 1;
                    newYear++;
                }
            }
        }
        
        return new Bai02_ClassDate(newDay, newMonth, newYear);
    }
        
    public static void main(String[] args) {
        Bai02_ClassDate date = new Bai02_ClassDate();
        
        date.input();
        
        if (date.checkDate()) {
            System.out.println("Ngay thang nam hop le");
        } else {
            System.out.println("Ngay thang nam khong hop le");
        }
        
        date.outputByFormat();
        
        Bai02_ClassDate newDate = date.addDate(5);
        System.out.print("Ngay thang nam moi la: ");
        newDate.outputByFormat();
    }
}
