package prolab3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
import static java.lang.System.exit;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public   class sekil extends JPanel  {
   
  sekil(){
      super();  
        
        
  }
          @Override
          public void paint(Graphics g){
                               super.paint(g);
                                 
                               this.setBackground(Color.black);
                               int j=1;
                                g.setColor(Color.white);
                                for(int i=20;i<=420;i=i+20){
                                 g.drawLine(20,i,420,i);   
                           
                              
                                }
                                
                                for(int i=20;i<=420;i=i+20){
                                g.drawLine(i,20,i,420);
                                }
                                for(int i=35;i<425;i=i+20){
                               g.drawString(""+j,5, i);
                                j++;
                                }
                                j=1;
                                for(int i=35;i<425;i=i+20){
                               g.drawString(""+j,i,10);
                                j++;
                                }
                          
                               g.setColor(Color.red);
                               Scanner keyboard=new Scanner(System.in);
        int dongu=1;
        int sayac1=0,sayac2=0,sayac3=0;
        int secim=0,motor = 0,deger = 0;
        double hiz = 0,hiz2=0,yük,kol,kapasite;
        boolean dogruMu;
        int sira;
        sekil s =new sekil();
       gezmeyenRobotlar robot2[]=new gezmeyenRobotlar[2];
       gezginRobotlar robot1[] =new gezginRobotlar[3];
       hibritRobot robot3[]=new hibritRobot[4];  
       System.out.println("Kac adet robot girmek istiyorsunuz?");
       dongu=keyboard.nextInt();
       if(dongu==0){
           exit(0);
       }
        Robot robot4[]=new Robot[dongu];
        int sayac=0;
         
        while(sayac<dongu){
            String isim1,isim2;
            int isim =0;
            do{
        System.out.println("Hangi tür robot istiyorsunuz?");
        System.out.println("(Gezgin,Manipulator,Hibrit)");
        isim1=keyboard.next();
            if(isim1.equalsIgnoreCase("gezgin")==true)
                isim=1;
            if(isim1.equalsIgnoreCase("manipulator")==true)
                isim=2;
             if(isim1.equalsIgnoreCase("hibrit")==true)
                isim=3;
            
            if(  isim != 1 && isim != 2 && isim != 3)
                    System.out.println("Yanlis giris yaptiniz!");
            } while(isim != 1 && isim != 2 && isim != 3 );
        
      
        if(isim==1){
           do{
            System.out.println("Gezgin robotlar icinden:\nHangi tür robot istiyorsunuz?");
            System.out.println("(Tekerlekli,Spider,Paletli)");
            isim2=keyboard.next();
            
            if(isim2.equalsIgnoreCase("tekerlekli")==true)
                secim=1;
            else if(isim2.equalsIgnoreCase("paletli")==true)
                secim=2;
            else if(isim2.equalsIgnoreCase("spider")==true)
                secim=3;
            
            if(secim != 1 && secim != 2 && secim != 3)
                   System.out.println("Yanlis giris yaptiniz.");
           } while(secim != 1 && secim != 2 && secim != 3);
            
            switch (secim){
                
                case 1: 
                    System.out.println("Robot hizini giriniz.");
                    hiz=keyboard.nextDouble();
                    
                    System.out.println("Motor sayisini giriniz.");
                    motor=keyboard.nextInt();
                    
                    System.out.println("Tekerlek sayisini giriniz.");
                    deger=keyboard.nextInt();
                    
                    System.out.println("Tasinicak yük miktarini giriniz.");
                    yük=keyboard.nextDouble();
                 
                    robot1[sayac1]=new tekerlekliRobot(sayac,hiz, deger, motor,yük);
                    sayac1++;
                    break;
                    
                case 2: 
                    System.out.println("Robot hizini giriniz.");
                    hiz=keyboard.nextDouble();
                    
                    System.out.println("Motor sayisini giriniz.");
                    motor=keyboard.nextInt();
                    
                    System.out.println("Palet sayisini giriniz.");
                    deger=keyboard.nextInt();
                    
                    System.out.println("Tasinicak yük miktarini giriniz.");
                    yük=keyboard.nextDouble();
                    
                    robot1[sayac1]=new paletliRobot(sayac,hiz, deger, motor,yük);
                    sayac1++;
                    break;
                    
                case 3: 
                    System.out.println("Robot hizini giriniz.");
                    hiz=keyboard.nextDouble();
                    
                    System.out.println("Motor sayisini giriniz.");
                    motor=keyboard.nextInt();
                    
                    System.out.println("Bacak sayisini giriniz.");
                    deger=keyboard.nextInt();
                    
                    System.out.println("Tasinicak yük miktarini giriniz.");
                    yük=keyboard.nextDouble();
                    
                    robot1[sayac1]=new spiderRobot(sayac,hiz, deger, motor,yük);
                    sayac1++;
                    break;
                    
                default: System.out.println("Yanlis giris yaptiniz.");
                    break;
            }
            
        }
        
        if(isim==2){
           
            do{
            System.out.println("Manipülatör robotlar icinden:\nHangi tür robot istiyorsunuz?");
            System.out.println("(Paralel,Seri)");
            isim2=keyboard.next();
            
            if(isim2.equalsIgnoreCase("paralel")==true)
                secim=1;
            else if(isim2.equalsIgnoreCase("seri")==true)
                secim=2;
            
            if(secim != 1 && secim != 2)
                    System.out.println("Yanlis giris yaptiniz.");
            } while(secim !=1 && secim != 2);
            
                switch(secim){
                    case 1: 
                       
                        
                        System.out.println("Kol uzunlugunu giriniz.");
                        kol=keyboard.nextDouble();
                        
                        System.out.println("Yük kapasitesini giriniz.");
                        kapasite=keyboard.nextDouble();
                        
                        System.out.println("Hizi giriniz.");
                        hiz=keyboard.nextDouble();
                        
                         System.out.println("Motor sayisini giriniz.");
                        motor=keyboard.nextInt();
                        
                        System.out.println("Yük miktarinin kapasiteden fazla \nolmamasina dikkat ediniz.");
                        System.out.println("Yük miktarini giriniz.");
                        yük=keyboard.nextDouble();
                        
                        robot2[sayac2]=new paralelRobot(sayac,kol,kapasite,hiz,yük,motor);
                        
                        while(robot2[sayac2].tasirMi(yük,kapasite)== false){
               System.out.println("yük kapasiteden fazladir yeni yuk giriniz\n");
                            yük=keyboard.nextDouble();
                            robot2[sayac2]=new paralelRobot(sayac,kol,kapasite,hiz,yük,motor);
      
                        }
                        sayac2++;
                        break;
                        
                    case 2 : 
                     System.out.println("Kol uzunlugunu giriniz.");
                        kol=keyboard.nextDouble();
                        
                        System.out.println("Yük kapasitesini giriniz.");
                        kapasite=keyboard.nextDouble();
                        
                        System.out.println("Hizi giriniz.");
                        hiz=keyboard.nextDouble();
                        
                         System.out.println("Motor sayisini giriniz.");
                        motor=keyboard.nextInt();
                        
                        System.out.println("Yük miktarinin kapasiteden fazla \nolmamasina dikkat ediniz.");
                        System.out.println("Yük miktarini giriniz.");
                        yük=keyboard.nextDouble();
                        robot2[sayac2]=new seriRobot(sayac,kol,kapasite,hiz,yük,motor);
                         while(robot2[sayac2].tasirMi(yük, kapasite)== false){
                             
                             System.out.println("girilen yuk miktari kapasiteden fazla yeni yük giriniz\n");
                                  yük=keyboard.nextDouble();
                                  robot2[sayac2]=new seriRobot(sayac,kol,kapasite,hiz,yük,motor);
                                  
                         }
                                sayac2++;
                        break;
                        
                    default: System.out.println("Yanlis giris yaptiniz.");
                    break;
              }
        }
                
         if(isim==3){
             do{
            System.out.println("Gezgin robot kısmı icin:\nHangi tür robot istiyorsunuz?");
            System.out.println("(Tekerlekli,Spider,Paletli)");
            isim2=keyboard.next();
            
            if(isim2.equalsIgnoreCase("tekerlekli")==true)
                secim=1;
            else if(isim2.equalsIgnoreCase("paletli")==true)
                secim=2;
            else if(isim2.equalsIgnoreCase("spider")==true)
                secim=3;
            
            if(secim != 1 && secim != 2 && secim != 3)
                   System.out.println("Yanlis giris yaptiniz.");
           } while(secim != 1 && secim != 2 && secim != 3);
             
             
            
            switch (secim){
                
                case 1: 
                    System.out.println("Robot hizini giriniz.");
                    hiz=keyboard.nextDouble();
                    
                    System.out.println("Tekerlek sayisini giriniz.");
                    deger=keyboard.nextInt();
                    break;
                    
                case 2: 
                    System.out.println("Robot hizini giriniz.");
                    hiz=keyboard.nextDouble();
                    
                    
                    System.out.println("Palet sayisini giriniz.");
                    deger=keyboard.nextInt();
                    break;
                    
                case 3: 
                    System.out.println("Robot hizini giriniz.");
                    hiz=keyboard.nextDouble();
                    
                    
                    
                    System.out.println("Bacak sayisini giriniz.");
                    deger=keyboard.nextInt();
                    break;
                    
                default: System.out.println("Yanlis giris yaptiniz.");
                    break;
            }
            
             System.out.println("Hibrit robotun sabitlenme süresini giriniz.");
             double sabit=keyboard.nextDouble();
             
             secim=0;
             
            do{
            System.out.println("Manipülatör robot kısmı icin:\nHangi tür robot istiyorsunuz?");
            System.out.println("(Paralel,Seri)");
            isim2=keyboard.next();
            
            if(isim2.equalsIgnoreCase("paralel")==true)
                secim=1;
            else if(isim2.equalsIgnoreCase("seri")==true)
                secim=2;
            
            if(secim != 1 && secim != 2)
                    System.out.println("Yanlis giris yaptiniz.");
            } while(secim !=1 && secim != 2);
            
                switch(secim){
                    case 1: 
                       
                        
                        System.out.println("Kol uzunlugunu giriniz.");
                        kol=keyboard.nextDouble();
                        
                        System.out.println("Yük kapasitesini giriniz.");
                        kapasite=keyboard.nextDouble();
                        
                        System.out.println("Gezinme hizini giriniz.");
                        hiz2=keyboard.nextDouble();
                        
                         System.out.println("Motor sayisini giriniz.");
                        motor=keyboard.nextInt();
                        
                        System.out.println("Yük miktarinin kapasiteden fazla \nolmamasina dikkat ediniz.");
                        System.out.println("Yük miktarini giriniz.");
                        yük=keyboard.nextDouble();
                        
                        robot3[sayac3]=new hibritRobot(sabit,sayac,isim,kol,kapasite,hiz,hiz2,yük,motor,deger);
                        
                        while(robot3[sayac3].tasirMi(yük,kapasite)== false){
               System.out.println("yük kapasiteden fazladir yeni yuk giriniz\n");
                            yük=keyboard.nextDouble();
                            robot3[sayac3]=new hibritRobot(sabit,sayac,isim,kol,kapasite,hiz,hiz2,yük,motor,deger);
                        
                        }
                        
                        break;
                        
                    case 2 : 
                     System.out.println("Kol uzunlugunu giriniz.");
                        kol=keyboard.nextDouble();
                        
                        System.out.println("Yük kapasitesini giriniz.");
                        kapasite=keyboard.nextDouble();
                        
                        System.out.println("Tasima hizini giriniz.");
                        hiz2=keyboard.nextDouble();
                        
                        
                        System.out.println("Yük miktarinin kapasiteden fazla \nolmamasina dikkat ediniz.");
                        System.out.println("Yük miktarini giriniz.");
                        yük=keyboard.nextDouble();
                        robot3[sayac3]=new hibritRobot(sabit,sayac,isim,kol,kapasite,hiz,hiz2,yük,motor,deger);
                         while(robot3[sayac3].tasirMi(yük, kapasite)== false){
                             
                             System.out.println("girilen yuk miktari kapasiteden fazla yeni yük giriniz\n");
                                  yük=keyboard.nextDouble();
                                  robot3[sayac3]=new hibritRobot(sabit,sayac,isim,kol,kapasite,hiz,hiz2,yük,motor,deger);
                         }
                               
                        break;
                        
                    default: System.out.println("Yanlis giris yaptiniz.");
                    break;
         }
                sayac3++;
        }
         sayac++;
    
        }
        
        double hiz1=0,hiz4=0,hiz3=0;
    
        if(sayac1==3){
            for(int i=0;i<3;i++){
                if(robot1[i].isim==1)
                    hiz1=robot1[i].gezinmeHizi;
                if(robot1[i].isim==2)
                    hiz4=robot1[i].gezinmeHizi;
                if(robot1[i].isim==3)
                    hiz3=robot1[i].gezinmeHizi;
                
            }
            dogruMu=robot1[0].Hepsihizkarsilastir(hiz1, hiz4, hiz3);
            if(dogruMu== false){
                System.out.println("Girdiginiz robotlarin hizlari bu şekilde olamaz.");
                exit (0);
            }
        }
        int temp=-1,temp1=0,temp2=0;
        if(sayac1==2){
            for(int i=0;i<2;i++){
                temp++;
                if(robot1[i].isim == 1){
                    hiz1=robot1[i].gezinmeHizi;
                    temp1=1;
                    break;
                } else if(robot1[i].isim == 2){
                    hiz1=robot1[i].gezinmeHizi;
                    temp2=i;
                }
            }
           if(temp1==1){
               hiz4=robot1[sayac1-temp-1].gezinmeHizi;
           }
           else 
               hiz4=robot1[sayac1-temp2-1].gezinmeHizi;  
           
           dogruMu=robot1[0].hizKarsilastir(hiz1, hiz4);
            if(dogruMu== false){
                System.out.println("Girdiginiz robotlarin hizlari bu şekilde olamaz.");
                exit (0);
            }
           
        }
        System.out.println("Hangi siradaki robotu kullanmak istiyorsunuz:");
        sira=keyboard.nextInt();
        
        if(sira>sayac){
            System.out.println("Böyle bir robot bulunmamakta.");
            return;
        }
     
            boolean gecme = false;
            int sira1 = 0,index = 0,problem=0,index1=0;
           for(int i=0;i<sayac1;i++){
               if(robot1[i].sira == sira){
                 sira1=1;
                 index=i;
                 problem=1;
                 gecme=robot1[i].gecerMi;
                   break;
               }
           }
           
           for(int i=0;i<sayac2;i++){
               if(robot2[i].getSira() == sira){
               sira1=2;
               problem=2;
               index=i;
               gecme=false;
                   break;
               }
           }
           for(int i=0;i<sayac3;i++){
               if(sira==robot3[i].sira){
               sira1=3;
               index=i;  
               problem=3;
               gecme=robot3[i].gecerMi;
                   break;
               }
           }
              if(problem==1){ //gezgin robot icin cözüm
              System.out.println("Kac adet engel girmek istiyorsunuz?");
              int engel=keyboard.nextInt();
              int sayac8=0;
              int engeller1[][]=new int[engel][1];
              int engeller2[][]=new int[engel][1];
              int x = 0,y = 0;
              g.setColor(Color.white);
              int i=0;
              j=0;
              while(sayac8 < engel){
                  do{
                  System.out.print("x:");
                  engeller1[sayac8][0]=keyboard.nextInt();
                  System.out.print("y:");
                  engeller2[sayac8][0]=keyboard.nextInt();
                  if(engeller1[sayac8][0] >20 || engeller2[sayac8][0]>20){
                      System.out.println("böyle bir engel girilemez");
                  }
                  } while(engeller1[sayac8][0] >20 || engeller2[sayac8][0]>20);
                  
                  g.fillRect(engeller1[sayac8][0]*20,engeller2[sayac8][0]*20,20,20);
                  sayac8++;
              }
              int yer ;
              do{ System.out.println("Robotu nereye koymak istiyorsunuz.");
               g.setColor(Color.red);
                  System.out.print("x:");
                  x=keyboard.nextInt();
                  System.out.print("y:");
                  y=keyboard.nextInt();
                  
                  if(x>20 || y >20)
                      System.out.println("Robot böyle bir yere konulamaz.");
              }while(x>20 || y>20);  
              g.fillOval(x*20,y*20,20,20);
              
             int secim3,fark;
             int hareket=1;
             int secim8,yer1=x*20,yer2=y*20;
             
             double eGecme=0; //engel gecme suresi
             int tHareket=0; //toplam hareket edilen birim
             
             boolean denkMi = false;
              while(hareket == 1){
               denkMi=false;
               String yon;   
         System.out.println("\nRobotu ne tarafa hareket ettirmek \nistiyorsun");
                  System.out.println("(ileri,geri,asagi,yukari)");
                    yon=keyboard.next();
                   denkMi=false;           
         
                          if(true==yon.equalsIgnoreCase("ileri")){
                      System.out.println("Kac birim:");
                      secim8=keyboard.nextInt();
                      tHareket=tHareket+secim8;
                      for(i=0;i<engel;i++){
 if(engeller1[i][0]*20>yer1 && engeller1[i][0]*20<=yer1+secim8*20 && engeller2[i][0]*20==yer2){
                        denkMi=true;
                        index1=engeller1[i][0];
               }   
                      }
                      if( denkMi == true){
                          if(gecme ==true){
                                  eGecme=s.engelGecme(robot1[index],eGecme);
                                  
                                   if(yer1+secim8*20>420){
                             System.out.println("izgara dişına çıkıldı");
                             g.fillOval(20*20,yer2,20,20);
                             fark=(420-yer1)/20-1;
                           problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                             return;
                      } else{
                                  yer1=yer1+secim8*20;
                                  g.fillOval(yer1,yer2,20,20);
                           }
                          }
                           else{
                 System.out.println("Robot ileri giderken engelle karşılaştı.");
                 yer1=yer1+secim8*20;
                 fark=(yer1-index1*20)/20;  
                 g.fillOval(index1*20-20,yer2,20,20);
                 problem1(robot1[index],eGecme,tHareket-fark);
                 return;
                          }
                      
                      }
                      else{
                          if(yer1+secim8*20>420){
                             System.out.println("izgara dişına çıkıldı");
                             g.fillOval(20*20,yer2,20,20);
                             fark=(420-yer1)/20-1;
                           problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                             return;
                      }
                          else{ yer1=yer1+secim8*20;
                          g.fillOval(yer1,yer2,20,20);
                      }
                      
                  }
                          }
                  
                  if(yon.equalsIgnoreCase("geri")==true){
                      System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket=tHareket+secim8;
                     for(i=0;i<engel;i++){
     if(engeller1[i][0]*20<yer1 && engeller1[i][0]*20>=yer1-secim8*20 && engeller2[i][0]*20==yer2){
                             denkMi=true;
                             index1=engeller1[i][0];
                      }
                      }
                      if( denkMi == true){
                          if(gecme==true){
                                  eGecme=s.engelGecme(robot1[index],eGecme);
                                  
                                  if(yer1-secim8*20<20){
                            System.out.println("Robot izgara disina cikti");
                            g.fillOval(20,yer2,20,20);
                            fark=(yer1-20)/20;
                            problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                            return;     
                      } else{
                                  yer1=yer1-secim8*20;
                                  g.fillOval(yer1,yer2,20,20);
                                  }
                          }
                           else{
                 System.out.println("Robot ileri gidekren engelle karşılaştı.");
                 
                 fark=(yer1-index1*20)/20-1;
                 System.out.println("fark"+fark);
                 g.fillOval(index1*20+20,yer2,20,20);
                 problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                 return;
                          }
                      }
                      else{
                          
                      if(yer1-secim8*20<20){
                            System.out.println("Robot izgara disina cikti");
                            g.fillOval(20,yer2,20,20);
                            fark=(yer1-20)/20;
                            problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                            return;     
                      }else{
                      yer1=yer1-secim8*20;
                      g.fillOval(yer1,yer2,20,20);
                      }
                      }
              }
               
                  
                  if(yon.equalsIgnoreCase("asagi")==true){
                     System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket=tHareket+secim8;
                     for(i=0;i<engel;i++){
 if(engeller2[i][0]*20>yer2 && engeller1[i][0]*20==yer1 && engeller2[i][0]*20<=yer2+secim8*20){
                              denkMi=true;
                              index1=engeller2[i][0];
                      }
                      }
                      if( denkMi == true){
                          if(gecme==true){
                                  eGecme=s.engelGecme(robot1[index],eGecme);
                                  
                                  if(yer2+secim8*20>420){
                              System.out.println("Robot izgara dişina çikti");
                                  g.fillOval(yer1,400,20,20); 
                                  fark=(420-yer2)/20-1;
                        problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                                  return;
                          }
                                  else{
                                  yer2=yer2+secim8*20;
                                  g.fillOval(yer1,yer2,20,20); 
                                  }
                          }
                           else{
                 yer2=yer2+secim8*20;
                 fark=(yer2-index1*20)/20;
                 g.fillOval(yer1,index1*20-20,20,20);
                 System.out.println("Robot ileri gidekren engelle karşilaştı.");
                 problem1(robot1[index],eGecme,tHareket-fark);
                 return;
                          }
                      
                      }
                      else{
                          
                          if(yer2+secim8*20>420){
                              System.out.println("Robot izgara dişina çikti");
                                  g.fillOval(yer1,400,20,20); 
                                  fark=(420-yer2)/20-1;
                        problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                                  return;
                          }
                          else{
                      yer2=yer2+secim8*20;
                      g.fillOval(yer1,yer2,20,20); 
                      }
                      }
                      }
                     
                 
                  if(yon.equalsIgnoreCase("yukari")==true){
                    System.out.println("Kac birim:");
                    secim8=keyboard.nextInt();
                    tHareket=tHareket+secim8; 
                    for(i=0;i<engel;i++){
 if(engeller2[i][0]*20<yer2 &&engeller1[i][0]*20==yer1 && engeller2[i][0]*20>=yer2-secim8*20){
                              denkMi=true;
                              index1=engeller2[i][0];
                      }
                      }
                      if( denkMi == true){
                          if(gecme== true){
                          eGecme=s.engelGecme(robot1[index],eGecme);
                            if(yer2-secim8*20<20){
                                   System.out.println("izgara dişina cikildi");
                                   g.fillOval(yer1,20,20,20); 
                                   fark=(yer2-20)/20;
                          problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                                   return;
                            }
                            else {yer2=yer2-secim8*20;
                          g.fillOval(yer1,yer2,20,20);
                            }
                          }
                          else{
                 System.out.println("Robot ileri gidekren engelle karşılaştı.");
                 fark=(yer2-index1*20)/20-1;
                 g.fillOval(yer1,index1*20+20,20,20);
                 problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                 return;
                          }
                      } else{
                          
                                  if(yer2-secim8*20<20){
                                   System.out.println("izgara dişina cikildi");
                                   g.fillOval(yer1,20,20,20); 
                                   fark=(yer2-20)/20;
                          problem1(robot1[index],eGecme,tHareket-(secim8-fark));
                                   return;
                                   
                                  } else{
                                 yer2=yer2-secim8*20;
                                 g.fillOval(yer1,yer2,20,20);
                                  }
                      }
                     
                       
                  }
                  System.out.println("robot tekrar hareket etsin mi?");
                  System.out.println("Evet ise 1'e basiniz. Hayirsa 0'a basiniz.");
                  int evet=keyboard.nextInt();
                  if(evet==1){
                      hareket=1;
                  }
                  else{
                      hareket=0;
                  }
              }
                  s.problem1(robot1[index], eGecme, tHareket);
          }
              
          if(problem==2){
                 int x=0,y=0;
                do{ System.out.println("Robotu nereye koymak istiyorsunuz.");
               g.setColor(Color.blue);
                  System.out.print("x:");
                  x=keyboard.nextInt();
                  System.out.print("y:");
                  y=keyboard.nextInt();
                  
                  if(x>20 || y >20)
                      System.out.println("Robot böyle bir yere konulamaz.");
              }while(x>20 || y>20);  
              g.fillOval(x*20,y*20,20,20);
                   int yer1=x;
                   int yer2=y;
                   int robotkol=(int) robot2[index].getKolUzunlugu();
             int secim3,fark;
             int hareket=1;
             int secim8;
             
             double eGecme=0; //engel gecme suresi
             int tHareket=0; //toplam hareket edilen birim
             
             boolean denkMi = false;
               int ykare;  
               int xkare;
                double hipotenus = 0 ;
              while(hareket == 1){
              String yon;   
            System.out.println("robotun kolunu ne tarafa hareket ettirmek \nistiyorsunuz");
                  System.out.println("(ileri,geri,asagi,yukari)");
                    yon=keyboard.next();
                      
         
                          if(yon.equalsIgnoreCase("ileri")==true){
                      System.out.println("Kac birim:");
                      secim8=keyboard.nextInt();
                      tHareket=tHareket+secim8;
                        if((secim8<=robotkol) && (secim8*20)+(yer1*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(400,yer2*20,20,20);
                             fark=20-yer1;
                             problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                        
                      if((secim8*20)+(yer1*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(400,yer2*20,20,20);
                             fark=20-yer1;
                             problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                    xkare=(yer1+secim8-x)*(yer1+secim8-x);
                   if(yer2-y==0){
                    ykare=0;
                   }else{
                       
                       ykare=(yer2-y)*(yer2-y);
                   }
                    hipotenus=ykare+xkare;
                      hipotenus= sqrt(hipotenus);
                              System.out.println(robotkol);
                      if(hipotenus<=robotkol){
                      g.fillRect(yer1*20+secim8*20, yer2*20,20,20);
                          yer1=secim8+yer1; 
                          
                         
                          
                      }
                      
                      else{
                         System.out.println("Kol buraya gidemez.");
                         for(int i=secim8-1;i>=0;i--){
                         xkare=(yer1+i-x)*(yer1+i-x);
                         hipotenus=ykare+xkare;
                         hipotenus= sqrt(hipotenus);
                         
                          if(hipotenus<=robotkol){
                          yer1=i+yer1;
                          g.fillRect(yer1*20,yer2*20,20,20); 
                          fark=secim8-i;
                          problem2(robot2[index],tHareket-fark);
                          return;
                      }
                         
                         }   
                      }
                          }
                  
                  if(yon.equalsIgnoreCase("asagi")==true){
                      System.out.println("Kac birim:");
                      secim8=keyboard.nextInt();
                      tHareket=tHareket+secim8;
                      if((secim8<=robotkol) && (secim8*20)+(yer2*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 400,20,20);
                             fark=20-yer2;
                             problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                      
                       if((secim8*20)+(yer2*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 400,20,20);
                             fark=20-yer2;
                             problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                      ykare=(yer2+secim8-y)*(yer2+secim8-y);
                      if(yer1-x==0){
                      xkare=0;
                      }
                      else{
                          xkare = (yer1-x)*(yer1-x);
                      }
                      
                      hipotenus= xkare+ykare;
                      hipotenus=sqrt(hipotenus);
                     if(hipotenus<=robotkol){
                         g.fillRect(yer1*20,yer2*20+secim8*20,20,20);
                         yer2=secim8+yer2;
                         
                     }
                     else{
                        System.out.println("Kol buraya gidemez.");
                        for(int i=secim8-1;i>=0;i--){
                         ykare=(yer2+i-y)*(yer2+i-y);
                         hipotenus= xkare+ykare;
                         hipotenus=sqrt(hipotenus);
                            if(hipotenus<=robotkol){
                            yer2=i+yer2;
                            g.fillRect(yer1*20,yer2*20,20,20);
                            fark=secim8-i;
                            problem2(robot2[index],tHareket-fark);
                            return;
                     }
                        }
    
                     }  
              }
              
               if(yon.equalsIgnoreCase("geri")==true){
                     System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket=tHareket+secim8;
                    if((secim8<=robotkol) && (secim8*20)-(yer1*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(20,yer2*20,20,20);
                                fark=yer1-1;
                                problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                    
                    if((secim8*20)-(yer1*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(20, yer2*20,20,20);
                                fark=yer1-1;
                                problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                     xkare=((yer1-secim8-x)*(yer1-secim8-x));
                   if(yer2-y==0){
                    ykare=0;
                   }else{
                       
                       ykare=(yer2-y)*(yer2-y);
                   }
                        hipotenus=ykare+xkare;
                        hipotenus= sqrt(hipotenus);
                              System.out.println(robotkol);
                      if(hipotenus<=robotkol){
                      g.fillRect(yer1*20-secim8*20, yer2*20,20,20);
                          
                      yer1=(yer1-secim8);
                         
                      }
                      
                      else{
                        System.out.println("Kol buraya gidemez.");
                         for(int i=secim8-1;i>=0;i--){
                            xkare=((yer1-i-x)*(yer1-i-x));
                            hipotenus=ykare+xkare;
                            hipotenus= sqrt(hipotenus);
                             if(hipotenus<=robotkol){
                             yer1=yer1-i;
                             g.fillRect(yer1*20,yer2*20,20,20);
                             fark=secim8-i;
                            problem2(robot2[index],tHareket-fark);
                             return;
                             }
                            
                         }
                        
                      }
                     
                      }
                  if(yon.equalsIgnoreCase("yukari")==true){
                     System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket=tHareket+secim8;
                     if((secim8<=robotkol) && (secim8*20)-(yer2*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 20,20,20);
                             fark=abs(yer2-1);
                             problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                     
                     if((secim8*20)-(yer2*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 20,20,20);
                             fark=abs(yer1-1);
                             problem2(robot2[index],tHareket-(secim8-fark));
                             return;
                      }
                     
                     
                     
                     xkare=abs(yer1-x)*abs(yer1-x);
                     ykare=(y-yer2+secim8)*(y-yer2+secim8);
                     
                     hipotenus= xkare+ykare;
                     hipotenus=sqrt(hipotenus);
                     
                     if(hipotenus<=robotkol){
                         yer2=yer2-secim8;
                         g.fillRect(yer1*20,yer2*20,20,20);
                         
                     } else{
                         System.out.println("Kol buraya gidemez.");
                         for(int i=secim8-1;i>=0;i--){
                             ykare=(y-yer2+i)*(y-yer2+i);
                             hipotenus= xkare+ykare;
                             hipotenus=sqrt(hipotenus);
                             if(hipotenus<=robotkol){
                                yer2=yer2-i;
                                g.fillRect(yer1*20,yer2*20,20,20);
                                fark=secim8-i;
                          problem2(robot2[index],tHareket-fark);
                                return;
                     }
                         }
                     }   
                  }    
                  System.out.println("robot tekrar hareket etsin mi?");
                  System.out.println("Evet ise 1'e basiniz. Hayirsa 0'a basiniz.");
                  int evet=keyboard.nextInt();
                  if(evet==1){
                      hareket=1;
                  }
                  else{
                      hareket=0;
                  }   
              }
              problem2(robot2[index],tHareket);
          }
          
           
          if(problem==3){
              System.out.println("Kac adet engel girmek istiyorsunuz?");
              int engel=keyboard.nextInt();
              int sayac8=0;
              int engeller1[][]=new int[engel][1];
              int engeller2[][]=new int[engel][1];
              int x = 0,y = 0;
              g.setColor(Color.white);
              int i=0;
              j=0;
              while(sayac8 < engel){
                  do{
                  System.out.print("x:");
                  engeller1[sayac8][0]=keyboard.nextInt();
                  System.out.print("y:");
                  engeller2[sayac8][0]=keyboard.nextInt();
                  if(engeller1[sayac8][0] >20 || engeller2[sayac8][0]>20){
                      System.out.println("böyle bir engel girilemez");
                  }
                  } while(engeller1[sayac8][0] >20 || engeller2[sayac8][0]>20);
                  
                  g.fillRect(engeller1[sayac8][0]*20,engeller2[sayac8][0]*20,20,20);
                  sayac8++;
              }
              int yer ;
              do{ System.out.println("Robotu nereden baslatmak istiyorsunuz.");
               g.setColor(Color.yellow);
                  System.out.print("x:");
                  x=keyboard.nextInt();
                  System.out.print("y:");
                  y=keyboard.nextInt();
                  
                  if(x>20 || y >20)
                      System.out.println("Robot böyle bir yere konulamaz.");
              }while(x>20 || y>20);  
              g.fillOval(x*20,y*20,20,20);
              
             int secim3,fark;
             int hareket=1;
             int secim8,yer1=x*20,yer2=y*20;
             
             double eGecme=0; //engel gecme suresi
             int tHareket=0; //toplam hareket edilen birim gezgin
             int tHareket1=0; //toplam hareket edilen birim manipulator
             boolean denkMi = false;
              System.out.println("Robotu sabitlenecegi yere götürünüz.");
              while(hareket == 1){
               denkMi=false;
               String yon;   
      System.out.println("\nRobotu ne tarafa hareket ettirmek \nistiyorsunuz");
                  System.out.println("(ileri,geri,yukari,asagi)");
                    yon=keyboard.next();
                   denkMi=false;           
         
                          if(yon.equalsIgnoreCase("ileri")==true){
                      System.out.println("Kac birim:");
                      secim8=keyboard.nextInt();
                      tHareket=tHareket+secim8;
                      for(i=0;i<engel;i++){
 if(engeller1[i][0]*20>yer1 && engeller1[i][0]*20<=yer1+secim8*20 && engeller2[i][0]*20==yer2){
                        denkMi=true;
                        index1=engeller1[i][0];
               }   
                      }
                      if( denkMi == true){
                          if(gecme ==true){
                                  eGecme=s.engelGecme(robot1[index],eGecme);
                                  
                                   if(yer1+secim8*20>420){
                             System.out.println("izgara dişına çıkıldı");
                             g.fillOval(20*20,yer2,20,20);
                             fark=(420-yer1)/20-1;
               problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket1);
                             return;
                      } else{
                                  yer1=yer1+secim8*20;
                                  g.fillOval(yer1,yer2,20,20);
                           }
                          }
                           else{
                 System.out.println("Robot ileri giderken engelle karşılaştı.");
                 yer1=yer1+secim8*20;
                 fark=(yer1-index1*20)/20;  
                 g.fillOval(index1*20-20,yer2,20,20);
                 problem3(robot3[index],eGecme,tHareket-fark,tHareket1);
                 return;
                          }
                      
                      }
                      else{
                          if(yer1+secim8*20>420){
                             System.out.println("izgara dişına çıkıldı");
                             g.fillOval(20*20,yer2,20,20);
                             fark=(420-yer1)/20-1;
                 problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket1);
                             return;
                      }
                          else{ yer1=yer1+secim8*20;
                          g.fillOval(yer1,yer2,20,20);
                      }
                      
                  }
                          }
                  
                  if(yon.equalsIgnoreCase("geri")==true){
                      System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket=tHareket+secim8;
                     for(i=0;i<engel;i++){
     if(engeller1[i][0]*20<yer1 && engeller1[i][0]*20>=yer1-secim8*20 && engeller2[i][0]*20==yer2){
                             denkMi=true;
                             index1=engeller1[i][0];
                      }
                      }
                      if( denkMi == true){
                          if(gecme==true){
                                  eGecme=s.engelGecme(robot1[index],eGecme);
                                  
                                  if(yer1-secim8*20<20){
                            System.out.println("Robot izgara disina cikti");
                            g.fillOval(20,yer2,20,20);
                            fark=(yer1-20)/20;
                problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket1);
                            return;     
                      } else{
                                  yer1=yer1-secim8*20;
                                  g.fillOval(yer1,yer2,20,20);
                                  }
                          }
                           else{
                 System.out.println("Robot ileri gidekren engelle karşılaştı.");
                 
                 fark=(yer1-index1*20)/20-1;
                 System.out.println("fark"+fark);
                 g.fillOval(index1*20+20,yer2,20,20);
                problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket);
                 return;
                          }
                      }
                      else{
                          
                      if(yer1-secim8*20<20){
                            System.out.println("Robot izgara disina cikti");
                            g.fillOval(20,yer2,20,20);
                            fark=(yer1-20)/20;
                problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket);
                            return;     
                      }else{
                      yer1=yer1-secim8*20;
                      g.fillOval(yer1,yer2,20,20);
                      }
                      }
              }
               
                  
                  if(yon.equalsIgnoreCase("asagi")==true){
                     System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket=tHareket+secim8;
                     for(i=0;i<engel;i++){
 if(engeller2[i][0]*20>yer2 && engeller1[i][0]*20==yer1 && engeller2[i][0]*20<=yer2+secim8*20){
                              denkMi=true;
                              index1=engeller2[i][0];
                      }
                      }
                      if( denkMi == true){
                          if(gecme==true){
                                  eGecme=s.engelGecme(robot1[index],eGecme);
                                  
                                  if(yer2+secim8*20>420){
                              System.out.println("Robot izgara dişina çikti");
                                  g.fillOval(yer1,400,20,20); 
                                  fark=(420-yer2)/20-1;
                problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket);
                                  return;
                          }
                                  else{
                                  yer2=yer2+secim8*20;
                                  g.fillOval(yer1,yer2,20,20); 
                                  }
                          }
                           else{
                 yer2=yer2+secim8*20;
                 fark=(yer2-index1*20)/20;
                 g.fillOval(yer1,index1*20-20,20,20);
                 System.out.println("Robot ileri gidekren engelle karşilaştı.");
                 problem3(robot3[index],eGecme,tHareket-fark,tHareket);
                 return;
                          }
                      
                      }
                      else{
                          
                          if(yer2+secim8*20>420){
                              System.out.println("Robot izgara dişina çikti");
                                  g.fillOval(yer1,400,20,20); 
                                  fark=(420-yer2)/20-1;
                 problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket);
                                  return;
                          }
                          else{
                      yer2=yer2+secim8*20;
                      g.fillOval(yer1,yer2,20,20); 
                      }
                      }
                      }
                     
                 
                  if(yon.equalsIgnoreCase("yukari")==true){
                    System.out.println("Kac birim:");
                    secim8=keyboard.nextInt();
                    tHareket=tHareket+secim8; 
                    for(i=0;i<engel;i++){
 if(engeller2[i][0]*20<yer2 &&engeller1[i][0]*20==yer1 && engeller2[i][0]*20>=yer2-secim8*20){
                              denkMi=true;
                              index1=engeller2[i][0];
                      }
                      }
                      if( denkMi == true){
                          if(gecme== true){
                          eGecme=s.engelGecme(robot1[index],eGecme);
                            if(yer2-secim8*20<20){
                                   System.out.println("izgara dişina cikildi");
                                   g.fillOval(yer1,20,20,20); 
                                   fark=(yer2-20)/20;
                problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket);
                                   return;
                            }
                            else {yer2=yer2-secim8*20;
                          g.fillOval(yer1,yer2,20,20);
                            }
                          }
                          else{
                 System.out.println("Robot ileri gidekren engelle karşılaştı.");
                 fark=(yer2-index1*20)/20-1;
                 g.fillOval(yer1,index1*20+20,20,20);
                 problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket);
                 return;
                          }
                      } else{
                          
                                  if(yer2-secim8*20<20){
                                   System.out.println("izgara dişina cikildi");
                                   g.fillOval(yer1,20,20,20); 
                                   fark=(yer2-20)/20;
                problem3(robot3[index],eGecme,tHareket-(secim8-fark),tHareket);
                                   return;
                                   
                                  } else{
                                 yer2=yer2-secim8*20;
                                 g.fillOval(yer1,yer2,20,20);
                                  }
                      }
                     
                       
                  }
                  System.out.println("Robot tekrar hareket etsin mi?");
                  System.out.println("Evet ise 1'e basiniz. Hayirsa 0'a basiniz.");
                  int evet=keyboard.nextInt();
                  if(evet==1){
                      hareket=1;
                  }
                  else{
                      hareket=0;
                  }
              }
               
            int robotkol=(int) robot3[index].getKolUzunlugu();
              yer1=yer1/20;
              yer2=yer2/20;
              x=yer1;
              y=yer2;
               int ykare;  
               int xkare;
               double hipotenus = 0 ;
                hareket=1;
                g.setColor(Color.ORANGE);
              while(hareket == 1){
               String yon;   
            System.out.println("Robotun kolunu ne tarafa hareket ettirmek \nistiyorsunuz");
                  System.out.println("(ileri,geri,yukari,asagi)");
                    yon=keyboard.next();
                      
         
                          if(yon.equalsIgnoreCase("ileri")==true){
                      System.out.println("Kac birim:");
                      secim8=keyboard.nextInt();
                      tHareket1=tHareket1+secim8;
                        if((secim8<=robotkol) && (secim8*20)+(yer1*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(400,yer2*20,20,20);
                             fark=20-yer1;
               problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                        
                      if((secim8*20)+(yer1*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(400,yer2*20,20,20);
                             fark=20-yer1;
           problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                    xkare=(yer1+secim8-x)*(yer1+secim8-x);
                   if(yer2-y==0){
                    ykare=0;
                   }else{
                       
                       ykare=(yer2-y)*(yer2-y);
                   }
                    hipotenus=ykare+xkare;
                    hipotenus= sqrt(hipotenus);
                      if(hipotenus<=robotkol){
                      g.fillRect(yer1*20+secim8*20, yer2*20,20,20);
                          yer1=secim8+yer1; 
                      }
                      
                      else{
                         System.out.println("Kol buraya gidemez.");
                         for(i=secim8-1;i>=0;i--){
                         xkare=(yer1+i-x)*(yer1+i-x);
                         hipotenus=ykare+xkare;
                         hipotenus= sqrt(hipotenus);
                         
                          if(hipotenus<=robotkol){
                          yer1=i+yer1;
                          g.fillRect(yer1*20,yer2*20,20,20); 
                          fark=secim8-i;
                   problem3(robot3[index],eGecme,tHareket,tHareket1-fark);
                          return;
                      }
                         
                         }   
                      }
                          }
                  
                   if(yon.equalsIgnoreCase("asagi")==true){
                      System.out.println("Kac birim:");
                      secim8=keyboard.nextInt();
                      tHareket1=tHareket1+secim8;
                      if((secim8<=robotkol) && (secim8*20)+(yer2*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 400,20,20);
                             fark=20-yer2;
                  problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                      
                       if((secim8*20)+(yer2*20)>=420){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 400,20,20);
                             fark=20-yer2;
                  problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                      ykare=(yer2+secim8-y)*(yer2+secim8-y);
                      if(yer1-x==0){
                      xkare=0;
                      }
                      else{
                          xkare = (yer1-x)*(yer1-x);
                      }
                      
                      hipotenus= xkare+ykare;
                      hipotenus=sqrt(hipotenus);
                     if(hipotenus<=robotkol){
                         g.fillRect(yer1*20,yer2*20+secim8*20,20,20);
                         yer2=secim8+yer2;
                         
                     }
                     else{
                        System.out.println("Kol buraya gidemez.");
                        for(i=secim8-1;i>=0;i--){
                         ykare=(yer2+i-y)*(yer2+i-y);
                         hipotenus= xkare+ykare;
                         hipotenus=sqrt(hipotenus);
                            if(hipotenus<=robotkol){
                            yer2=i+yer2;
                            g.fillRect(yer1*20,yer2*20,20,20);
                            fark=secim8-i;
                  problem3(robot3[index],eGecme,tHareket,tHareket1-fark);
                            return;
                     }
                        }
    
                     }  
              }
              
                  if(yon.equalsIgnoreCase("geri")==true){
                     System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket1=tHareket1+secim8;
                    if((secim8<=robotkol) && (secim8*20)-(yer1*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(20,yer2*20,20,20);
                                fark=yer1-1;
                problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                    
                    if((secim8*20)-(yer1*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(20, yer2*20,20,20);
                                fark=yer1-1;
                problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                     xkare=((yer1-secim8-x)*(yer1-secim8-x));
                   if(yer2-y==0){
                    ykare=0;
                   }else{
                       
                       ykare=(yer2-y)*(yer2-y);
                   }
                        hipotenus=ykare+xkare;
                        hipotenus= sqrt(hipotenus);
                      if(hipotenus<=robotkol){
                      g.fillRect(yer1*20-secim8*20, yer2*20,20,20);
                          
                      yer1=(yer1-secim8);
                         
                      }
                      
                      else{
                        System.out.println("Kol buraya gidemez.");
                         for(i=secim8-1;i>=0;i--){
                            xkare=((yer1-i-x)*(yer1-i-x));
                            hipotenus=ykare+xkare;
                            hipotenus= sqrt(hipotenus);
                             if(hipotenus<=robotkol){
                             yer1=yer1-i;
                             g.fillRect(yer1*20,yer2*20,20,20);
                             fark=secim8-i;
                 problem3(robot3[index],eGecme,tHareket,tHareket1-fark);
                             return;
                             }
                            
                         }
                        
                      }
                     
                      }
                   if(yon.equalsIgnoreCase("yukari")==true){
                     System.out.println("Kac birim:");
                     secim8=keyboard.nextInt();
                     tHareket1=tHareket1+secim8;
                     if((secim8<=robotkol) && (secim8*20)-(yer2*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 20,20,20);
                             fark=abs(yer2-1);
                problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                     
                     if((secim8*20)-(yer2*20)>=20){
                            System.out.println("izgara dışına çıkıldı");
                             g.fillRect(yer1*20, 20,20,20);
                             fark=abs(yer1-1);
                problem3(robot3[index],eGecme,tHareket,tHareket1-(secim8-fark));
                             return;
                      }
                     
                     
                     
                     xkare=abs(yer1-x)*abs(yer1-x);
                     ykare=(y-yer2+secim8)*(y-yer2+secim8);
                     
                     hipotenus= xkare+ykare;
                     hipotenus=sqrt(hipotenus);
                     
                     if(hipotenus<=robotkol){
                         yer2=yer2-secim8;
                         g.fillRect(yer1*20,yer2*20,20,20);
                         
                     } else{
                         System.out.println("Kol buraya gidemez.");
                         for( i=secim8-1;i>=0;i--){
                             ykare=(y-yer2+i)*(y-yer2+i);
                             hipotenus= xkare+ykare;
                             hipotenus=sqrt(hipotenus);
                             if(hipotenus<=robotkol){
                                yer2=yer2-i;
                                g.fillRect(yer1*20,yer2*20,20,20);
                                fark=secim8-i;
                 problem3(robot3[index],eGecme,tHareket,tHareket1-fark);
                                return;
                     }
                         }
                     }   
                  }    
                  System.out.println("Robot tekrar hareket etsin mi?");
                  System.out.println("Evet ise 1'e basiniz. Hayirsa 0'a basiniz.");
                  int evet=keyboard.nextInt();
                  if(evet==1){
                      hareket=1;
                  }
                  else{
                      hareket=0;
                  }   
              }
           problem3(robot3[index],eGecme,tHareket,tHareket1);   
          }
          }
          
              double engelGecme(gezginRobotlar robot1,double eGecme){
                  return robot1.gecmeHizi+eGecme;
             }
              
             double engelGecme(hibritRobot robot1,double eGecme){
                  return robot1.gecmeHizi+eGecme;
             }
             
    void problem1(gezginRobotlar robot1,double eGecme,int tHareket){
        double tSüre;
        tSüre=(tHareket*10)/robot1.gezinmeHizi;
        tSüre=tSüre+eGecme;
        
        System.out.println("Toplam gecen süre:"+tSüre+"sn");
        System.out.println("Engel gecme süresi:"+eGecme+"sn");
        
    }
    
    void problem2(gezmeyenRobotlar robot1,int tHareket){
        double tSüre;
         tSüre=(tHareket*10)/robot1.getTasimaHizi();
         System.out.println("Toplam gecen süre:"+tSüre+"sn");
    }
        
    void problem3(hibritRobot robot1,double eGecme,int tHareket,int hareket){
        double tSüre=0;
        tSüre=(tHareket*10)/robot1.gezinmeHizi;
        tSüre=tSüre+eGecme;
        tSüre=((hareket*10)/robot1.tasimaHizi)+tSüre;
        
            if(hareket != 0){
                tSüre=tSüre+robot1.sabitlenme;
            }
        
        System.out.println("Toplam gecen süre:"+tSüre+"sn");
    }
    }
