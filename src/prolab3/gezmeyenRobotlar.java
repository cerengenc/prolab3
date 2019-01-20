package prolab3;

public interface gezmeyenRobotlar extends Robot {
    
   
     boolean tasirMi(double yük,double kapasite);
     boolean hangisiAgir(double yük1,double yük2);
     double getKolUzunlugu();
     double getYukKapasitesi();
     double getTasimaHizi();
    
}
