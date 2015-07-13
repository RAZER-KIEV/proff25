package hw2;

/**
 * Created by GFalcon on 30.05.15.
 * Ќаписать класс представл€ющий парковку. — методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удал€емую машину
 ћетоды выбрасывают ислключени€ IndexOutOfBoundsException и ParkFullException

 Ќаписать модульный тест на класс Parking.

  лассы задани€:
 hw2.park.Parking
 hw2.park.Car
 */
public class Park {
 public static void main(String[] args){

 }
}

class Parking{
 private Car[] place;
 private int size;
 Parking(int size){
  this.place = new Car[size];
  this.size = size;
 }
 public int park(Car car) throws Exception {
  int pl;
  for (pl = 0; pl < this.getSize(); pl++){
   if (place[pl] == null) {
    place[pl] = car;
    car.setPark(true);
    return pl + 1;
   }
  }
  throw new Exception("ParkFullException");
 }
 public Car leave(int placeNumber) throws Exception {
  if (placeNumber < 1 || placeNumber > this.getSize()) throw new Exception("IndexOutOfBoundsException");
  Car leaveCar = place[placeNumber - 1];
  leaveCar.setPark(false);
  place[placeNumber - 1] = null;
  return leaveCar;
 }
 public int getSize(){
  return this.size;
 }
}
class Car{
 private String number;
 private boolean park; // признак, что машина запаркована

 Car(){
  this("AA 0000");
 }
 Car(int num){
  this(num, false);
 }
 Car(String num){
  this(num, false);
 }
 Car(int num, boolean park){
  this.setNumber(num);
  this.setPark(park);
 }
 Car(String num, boolean park){
  this.setNumber(num);
  this.setPark(park);
 }
 public String getNumber(){
  return this.number;
 }
 public void setNumber(String number){
  this.number = number;
 }
 public void setNumber(int number){
  this.number = strInt(number);
 }

 public boolean isPark() {
  return park;
 }

 public void setPark(boolean park) {
  this.park = park;
 }

 private String strInt(int num){
  String str = "";
  if (num < 10){
   str = "AA 000" + num;
  } else if (num < 100){
   str = "AA 00" + num;
  } else if (num < 1000){
   str = "AA 0" + num;
  } else {
   str = "AA " + num;
  }
  return str;
 }
}

class ParkingTest{
}