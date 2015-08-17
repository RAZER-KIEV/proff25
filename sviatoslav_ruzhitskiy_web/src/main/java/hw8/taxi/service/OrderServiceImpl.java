package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ПК on 15.07.2015.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private int portionsize=1;

    @Autowired
    ClientDao clientDao;

    @Autowired
    OrderDao orderDao;


    @Override
    public Order read(Long id) {
        return orderDao.read(id);
    }

    @Override
    public boolean updateOrder(Order order) {
        orderDao.update(order);
        return true;
    }

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if(orderDao.read(id)!=null) {
            editOrder(id,client,amount,addressFrom,addressTo);
            return false;

        } else {
        Order order = new Order(id, new Date(),client,Double.parseDouble(amount),addressFrom,addressTo);
        orderDao.create(order);}
         return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        Order order = orderDao.read(id);
        if(order==null) {
            throw new OrderException("Order with current id not exist!");
        }
        order.setClient(client);
        order.setOrderSum(Double.parseDouble(amount));
        order.setDepartureAddress(addressFrom);
        order.setDestinationAddress(addressTo);
        orderDao.update(order);
    }

    @Override
    public List showOrders(Long from, Long to) {
        return orderDao.showOrders(from, to);
    }

    @Override
    public List showOrdersByPortion() {
        List<Order> orderList = new ArrayList<>();
        boolean flag=true;
        for (int i=0; flag==true; i+=portionsize ){
            List<Order> orderListBuff=new ArrayList<>();
            orderListBuff=orderDao.findAllbyPortion(i, i + portionsize);
            if(orderListBuff.isEmpty()){flag=false;}
           else orderList.addAll(orderListBuff);
        }

        return orderList;
    }
    // -----------------ORDER GENERATOR ---------------------!

    private String adresesStr="114 Edgewood Road \n" +
            "Lowell, MA 01851 " +
            "357 Buckingham Drive" +
            "Orange, NJ 07050" +
            "994 Cedar Lane" +
            "Monroeville, PA 15146" +
            "677 Center Street " +
            "Princeton, NJ 08540 " +
            "313 Park Street " +
            "Royersford, PA 19468 " +
            "212 Hamilton Road  " +
            "Lansdowne, PA 19050 " +
            "596 Edgewood Road  " +
            "Joliet, IL 60435 " +
            "682 John Street  " +
            "Grove City, OH 43123 " +
            "18 Sycamore Drive  " +
            "Waldorf, MD 20601 " +
            "921 Poplar Street  " +
            "Parkersburg, WV 26101 " +
            "48 Harrison Street  " +
            "Palos Verdes Peninsula, CA 90274 " +
            "467 Route 41  " +
            "Charlottesville, VA 22901 " +
            "510 Central Avenue  " +
            "Bradenton, FL 34203 " +
            "749 Orchard Lane  " +
            "Opa Locka, FL 33054 " +
            "627 Fairway Drive  " +
            "Grand Forks, ND 58201 " +
            "865 12th Street East  " +
            "Selden, NY 11784 " +
            "619 Route 6  " +
            "New Orleans, LA 70115 " +
            "64 Cooper Street  " +
            "Port Huron, MI 48060 " +
            "579 Queen Street  " +
            "Bristow, VA 20136 " +
            "564 MainTaxiTeser Street  " +
            "Tiffin, OH 44883 " +
            "891 Washington Avenue  " +
            "Findlay, OH 45840 " +
            "722 Madison Street  " +
            "El Paso, TX 79930 " +
            "432 Beechwood Drive  " +
            "Joliet, IL 60435 " +
            "51 Devon Court  " +
            "Rolla, MO 65401 " +
            "674 Windsor Court  " +
            "Oak Creek, WI 53154 " +
            "559 Woodland Avenue  " +
            "Butte, MT 59701 " +
            "954 Smith Street  " +
            "Belleville, NJ 07109 " +
            "627 Schoolhouse Lane  " +
            "Reno, NV 89523 " +
            "324 School Street  " +
            "Hartsville, SC 29550 " +
            "378 Lake Avenue  " +
            "Stafford, VA 22554 " +
            "707 Street Road  " +
            "Salem, MA 01970 " +
            "375 Ann Street  " +
            "Villa Rica, GA 30180 " +
            "69 Cedar Street  " +
            "Harlingen, TX 78552 " +
            "427 Taylor Street  " +
            "Waukegan, IL 60085 " +
            "860 Park Place  " +
            "Hamburg, NY 14075 " +
            "125 Cambridge Road  " +
            "Benton Harbor, MI 49022 " +
            "559 Route 6  " +
            "Williamstown, NJ 08094 " +
            "803 Pleasant Street  " +
            "Ottawa, IL 61350 " +
            "254 8th Street West  " +
            "Mahwah, NJ 07430 " +
            "898 Route 7  " +
            "Glendale Heights, IL 60139 " +
            "313 13th Street  " +
            "Medford, MA 02155 " +
            "644 Dogwood Lane  " +
            "Chippewa Falls, WI 54729 " +
            "901 Water Street  " +
            "Massillon, OH 44646 " +
            "924 Lexington Drive  " +
            "Roslindale, MA 02131 " +
            "865 Cooper Street  " +
            "Crofton, MD 21114 " +
            "98 Summer Street  " +
            "Hope Mills, NC 28348 " +
            "404 Strawberry Lane  " +
            "The Villages, FL 32162 " +
            "369 Brookside Drive  " +
            "Grand Blanc, MI 48439 " +
            "734 5th Street South  " +
            "Parkersburg, WV 26101 " +
            "376 2nd Street North  " +
            "Arlington, MA 02474 " +
            "356 Route 7  " +
            "Fort Worth, TX 76110 " +
            "9 Franklin Street  " +
            "Thornton, CO 80241 " +
            "989 MainTaxiTeser Street  " +
            "Bethpage, NY 11714 " +
            "613 Sunset Drive  " +
            "Bluffton, SC 29910 " +
            "480 Manor Drive  " +
            "Cocoa, FL 32927 " +
            "387 Mulberry Street  " +
            "Ambler, PA 19002 " +
            "994 Dogwood Lane  " +
            "Milledgeville, GA 31061 " +
            "161 Elizabeth Street  " +
            "Woodside, NY 11377 " +
            "18 Glenwood Avenue  " +
            "Glen Ellyn, IL 60137" +
            "402 Broad Street  " +
            "Conyers, GA 30012 " +
            "905 Ridge Street  " +
            "Jacksonville, NC 28540 " +
            "356 10th Street  " +
            "Brockton, MA 02301 " +
            "678 Evergreen Drive  " +
            "Jonesboro, GA 30236 " +
            "226 Cedar Court  " +
            "Melrose, MA 02176 " +
            "73 Cambridge Road  " +
            "Valdosta, GA 31601 " +
            "191 James Street  " +
            "Bluffton, SC 29910 " +
            "18 Ridge Avenue  " +
            "Georgetown, SC 29440 " +
            "161 Hartford Road  " +
            "Canandaigua, NY 14424 " +
            "426 Penn Street  " +
            "Green Cove Springs, FL 32043 " +
            "780 Broad Street  " +
            "Merrick, NY 11566 " +
            "443 Lincoln Street  " +
            "New Milford, CT 06776 " +
            "403 Center Street  " +
            "Windsor Mill, MD 21244" +
            "9 Euclid Avenue " +
            "Hermitage, TN 37076" +
            "552 Pheasant Run " +
            "Branford, CT 06405" +
            "43 3rd Street " +
            "Manahawkin, NJ 08050" +
            "202 Manor Drive " +
            "Galloway, OH 43119" +
            "67 8th Avenue " +
            "Largo, FL 33771" +
            "461 4th Street North " +
            "Asheboro, NC 27205" +
            "294 Redwood Drive " +
            "Homestead, FL 33030" +
            "856 Woodland Drive " +
            "Mount Juliet, TN 37122" +
            "109 Lafayette Avenue " +
            "Somerset, NJ 08873" +
            "332 Route 2 " +
            "Lowell, MA 01851" +
            "750 Ann Street " +
            "Mesa, AZ 85203" +
            "688 Broadway " +
            "Brunswick, GA 31525" +
            "303 Pearl Street " +
            "Hinesville, GA 31313" +
            "739 Warren Street " +
            "Brunswick, GA 31525" +
            "622 Canterbury Court " +
            "Clinton Township, MI 48035" +
            "5 Walnut Street " +
            "Traverse City, MI 49684" +
            "828 Ridge Avenue " +
            "Altoona, PA 16601" +
            "344 Lakeview Drive " +
            "Hixson, TN 37343" +
            "766 Oak Lane " +
            "Batavia, OH 45103" +
            "60 Maple Street " +
            "East Brunswick, NJ 08816" +
            "941 Atlantic Avenue " +
            "Lawndale, CA 90260" +
            "113 MainTaxiTeser Street West " +
            "Rapid City, SD 57701" +
            "261 Mill Road " +
            "Piqua, OH 45356" +
            "912 2nd Street East " +
            "Rowlett, TX 75088" +
            "971 Harrison Avenue " +
            "Parlin, NJ 08859" +
            "155 9th Street " +
            "Independence, KY 41051" +
            "944 Adams Street " +
            "Wooster, OH 44691" +
            "760 Victoria Court " +
            "Skokie, IL 60076";


    String [] adresesArray = new String[100];

    private  void init(){
       // adresesStr.replaceAll("\\n", " ");
        adresesArray = adresesStr.split(",");
    }

    public Client getRandClient(){

        Long qunt = (Long) clientDao.getCliensQuantity();
        System.out.println("getRandClient/Quantity is: "+qunt);
        Integer rand = ((int) ((Math.random() * qunt)));
        System.out.println("Rand id is: "+rand);

        return clientDao.read((long) rand);

    }

    public String generateAdress(){

        return adresesArray[(int)(Math.random() * (adresesArray.length))];
    }

    public Date generateRandDate(){
        long yearTime = 12L * 30L * 24L * 60L * 60L * 1000L;
        Date randomDate = new Date(System.currentTimeMillis()-(long)(Math.random()*yearTime));
        return randomDate;
    }


    public Long createOrdersInDB(int quantity){
        init();
        Long id = null;
        //Order(Date orderDay, Client client, Double orderSum, String departureAddress, String destinationAddress)
        for (int i = 0; i < quantity; i++) {
            Order order = new Order(generateRandDate(),getRandClient(),(Math.random()*150),generateAdress(),generateAdress());
            id = orderDao.create(order);
        }
        return id;
    }

    @Override
    public List findInCompleteOrders() {
        return orderDao.findInCompleteOrders();
    }


}
