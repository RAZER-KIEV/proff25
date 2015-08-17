package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.domain.Client;
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
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientDao clientDao;

    public ClientServiceImpl() {
        init();
    }

    @Override
    public boolean createClient(String name, String surname, String phone, String address) throws OrderException {
        Client client = new Client(name,surname,phone,address);
        if(!(clientDao.create(client)==null)){
        return true;
       }
        return false;
    }

        @Override
        public Client findClientById(Long id) {
                return clientDao.read(id);
        }

        @Override
        public List showClientsByPortion(int portionSize) {
                List<Client> clientList = new ArrayList<>();
                Long size= clientDao.getDBSize();

                for (int i=0; i<size; i+=portionSize ){
                        List<Client> orderListBuff=new ArrayList<>();
                        orderListBuff=clientDao.showClientsByPortion(i, portionSize);
                        clientList.addAll(orderListBuff);

                }
                for (Client client:clientList){
                        System.out.println(client);
                }
                return clientList;
    }

    @Override
    public List showClientsGtSum(int sum) {
        return  clientDao.showClientsGtSum(sum);
    }

    @Override
    public List showClientsLastMonth() {
        return clientDao.showClientsLastMonth();
    }

// -----------------CLIENT GENERATOR ---------------------!

    private String names="Luna Tibbetts  \n" +
            "Jessi Huerta  \n" +
            "Marilynn Burnette  \n" +
            "Laurine Gallaway  \n" +
            "Margorie Bulluck  \n" +
            "Shawnna Bushman  \n" +
            "Kristina Mooneyham  \n" +
            "Ciara Eames  \n" +
            "Wendolyn Taff  \n" +
            "Lavonna Groesbeck  \n" +
            "Terisa Musgrave  \n" +
            "Shayne Bartolotta  \n" +
            "Jean Komar  \n" +
            "Gennie Huebner  \n" +
            "Cheryle Fertig  \n" +
            "Maegan Dildy  \n" +
            "Lenny Gayhart  \n" +
            "Elfriede Trisler  \n" +
            "Thomasina Hayworth  \n" +
            "Terra Kerrick  \n" +
            "Laronda Cervone  \n" +
            "Harriett Laramee  \n" +
            "Tanisha Cue  \n" +
            "Ronald Atkins  \n" +
            "Berniece Rosenzweig  \n" +
            "Iliana Lembo  \n" +
            "Son Tice  \n" +
            "Janay Lawler  \n" +
            "Dinah Argento  \n" +
            "Lucinda Benford  \n" +
            "Kamilah Lujan  \n" +
            "Lance Cliff  \n" +
            "Lakeesha Geil  \n" +
            "Sharell Fender  \n" +
            "Alexandria Worthey  \n" +
            "Lorraine Faivre  \n" +
            "Mayola Caviness  \n" +
            "Elisa Bame  \n" +
            "Marisela Friday  \n" +
            "Dannette Munos  \n" +
            "Kisha Shira  \n" +
            "Dalene Cobbs  \n" +
            "Zofia Sipos  \n" +
            "Isobel Mallery  \n" +
            "Francina Thurston  \n" +
            "Joie Rumfelt  \n" +
            "Mai Kaup  \n" +
            "Gala Crete  \n" +
            "Cliff Maskell  \n" +
            "Iluminada Mccuiston ";


    private String adresesStr="114 Edgewood Road \n" +
            "Lowell, MA 01851\n" +
            "357 Buckingham Drive \n" +
            "Orange, NJ 07050\n" +
            "994 Cedar Lane \n" +
            "Monroeville, PA 15146\n" +
            "677 Center Street \n" +
            "Princeton, NJ 08540\n" +
            "313 Park Street \n" +
            "Royersford, PA 19468\n" +
            "212 Hamilton Road \n" +
            "Lansdowne, PA 19050\n" +
            "596 Edgewood Road \n" +
            "Joliet, IL 60435\n" +
            "682 John Street \n" +
            "Grove City, OH 43123\n" +
            "18 Sycamore Drive \n" +
            "Waldorf, MD 20601\n" +
            "921 Poplar Street \n" +
            "Parkersburg, WV 26101\n" +
            "48 Harrison Street \n" +
            "Palos Verdes Peninsula, CA 90274\n" +
            "467 Route 41 \n" +
            "Charlottesville, VA 22901\n" +
            "510 Central Avenue \n" +
            "Bradenton, FL 34203\n" +
            "749 Orchard Lane \n" +
            "Opa Locka, FL 33054\n" +
            "627 Fairway Drive \n" +
            "Grand Forks, ND 58201\n" +
            "865 12th Street East \n" +
            "Selden, NY 11784\n" +
            "619 Route 6 \n" +
            "New Orleans, LA 70115\n" +
            "64 Cooper Street \n" +
            "Port Huron, MI 48060\n" +
            "579 Queen Street \n" +
            "Bristow, VA 20136\n" +
            "564 MainTaxiTester Street \n" +
            "Tiffin, OH 44883\n" +
            "891 Washington Avenue \n" +
            "Findlay, OH 45840\n" +
            "722 Madison Street \n" +
            "El Paso, TX 79930\n" +
            "432 Beechwood Drive \n" +
            "Joliet, IL 60435\n" +
            "51 Devon Court \n" +
            "Rolla, MO 65401\n" +
            "674 Windsor Court \n" +
            "Oak Creek, WI 53154\n" +
            "559 Woodland Avenue \n" +
            "Butte, MT 59701\n" +
            "954 Smith Street \n" +
            "Belleville, NJ 07109\n" +
            "627 Schoolhouse Lane \n" +
            "Reno, NV 89523\n" +
            "324 School Street \n" +
            "Hartsville, SC 29550\n" +
            "378 Lake Avenue \n" +
            "Stafford, VA 22554\n" +
            "707 Street Road \n" +
            "Salem, MA 01970\n" +
            "375 Ann Street \n" +
            "Villa Rica, GA 30180\n" +
            "69 Cedar Street \n" +
            "Harlingen, TX 78552\n" +
            "427 Taylor Street \n" +
            "Waukegan, IL 60085\n" +
            "860 Park Place \n" +
            "Hamburg, NY 14075\n" +
            "125 Cambridge Road \n" +
            "Benton Harbor, MI 49022\n" +
            "559 Route 6 \n" +
            "Williamstown, NJ 08094\n" +
            "803 Pleasant Street \n" +
            "Ottawa, IL 61350\n" +
            "254 8th Street West \n" +
            "Mahwah, NJ 07430\n" +
            "898 Route 7 \n" +
            "Glendale Heights, IL 60139\n" +
            "313 13th Street \n" +
            "Medford, MA 02155\n" +
            "644 Dogwood Lane \n" +
            "Chippewa Falls, WI 54729\n" +
            "901 Water Street \n" +
            "Massillon, OH 44646\n" +
            "924 Lexington Drive \n" +
            "Roslindale, MA 02131\n" +
            "865 Cooper Street \n" +
            "Crofton, MD 21114\n" +
            "98 Summer Street \n" +
            "Hope Mills, NC 28348\n" +
            "404 Strawberry Lane \n" +
            "The Villages, FL 32162\n" +
            "369 Brookside Drive \n" +
            "Grand Blanc, MI 48439\n" +
            "734 5th Street South \n" +
            "Parkersburg, WV 26101\n" +
            "376 2nd Street North \n" +
            "Arlington, MA 02474\n" +
            "356 Route 7 \n" +
            "Fort Worth, TX 76110\n" +
            "9 Franklin Street \n" +
            "Thornton, CO 80241\n" +
            "989 MainTaxiTester Street \n" +
            "Bethpage, NY 11714\n" +
            "613 Sunset Drive \n" +
            "Bluffton, SC 29910\n" +
            "480 Manor Drive \n" +
            "Cocoa, FL 32927\n" +
            "387 Mulberry Street \n" +
            "Ambler, PA 19002\n" +
            "994 Dogwood Lane \n" +
            "Milledgeville, GA 31061\n" +
            "161 Elizabeth Street \n" +
            "Woodside, NY 11377\n" +
            "18 Glenwood Avenue \n" +
            "Glen Ellyn, IL 60137\n" +
            "402 Broad Street \n" +
            "Conyers, GA 30012\n" +
            "905 Ridge Street \n" +
            "Jacksonville, NC 28540\n" +
            "356 10th Street \n" +
            "Brockton, MA 02301\n" +
            "678 Evergreen Drive \n" +
            "Jonesboro, GA 30236\n" +
            "226 Cedar Court \n" +
            "Melrose, MA 02176\n" +
            "73 Cambridge Road \n" +
            "Valdosta, GA 31601\n" +
            "191 James Street \n" +
            "Bluffton, SC 29910\n" +
            "18 Ridge Avenue \n" +
            "Georgetown, SC 29440\n" +
            "161 Hartford Road \n" +
            "Canandaigua, NY 14424\n" +
            "426 Penn Street \n" +
            "Green Cove Springs, FL 32043\n" +
            "780 Broad Street \n" +
            "Merrick, NY 11566\n" +
            "443 Lincoln Street \n" +
            "New Milford, CT 06776\n" +
            "403 Center Street \n" +
            "Windsor Mill, MD 21244\n" +
            "9 Euclid Avenue \n" +
            "Hermitage, TN 37076\n" +
            "552 Pheasant Run \n" +
            "Branford, CT 06405\n" +
            "43 3rd Street \n" +
            "Manahawkin, NJ 08050\n" +
            "202 Manor Drive \n" +
            "Galloway, OH 43119\n" +
            "67 8th Avenue \n" +
            "Largo, FL 33771\n" +
            "461 4th Street North \n" +
            "Asheboro, NC 27205\n" +
            "294 Redwood Drive \n" +
            "Homestead, FL 33030\n" +
            "856 Woodland Drive \n" +
            "Mount Juliet, TN 37122\n" +
            "109 Lafayette Avenue \n" +
            "Somerset, NJ 08873\n" +
            "332 Route 2 \n" +
            "Lowell, MA 01851\n" +
            "750 Ann Street \n" +
            "Mesa, AZ 85203\n" +
            "688 Broadway \n" +
            "Brunswick, GA 31525\n" +
            "303 Pearl Street \n" +
            "Hinesville, GA 31313\n" +
            "739 Warren Street \n" +
            "Brunswick, GA 31525\n" +
            "622 Canterbury Court \n" +
            "Clinton Township, MI 48035\n" +
            "5 Walnut Street \n" +
            "Traverse City, MI 49684\n" +
            "828 Ridge Avenue \n" +
            "Altoona, PA 16601\n" +
            "344 Lakeview Drive \n" +
            "Hixson, TN 37343\n" +
            "766 Oak Lane \n" +
            "Batavia, OH 45103\n" +
            "60 Maple Street \n" +
            "East Brunswick, NJ 08816\n" +
            "941 Atlantic Avenue \n" +
            "Lawndale, CA 90260\n" +
            "113 MainTaxiTester Street West \n" +
            "Rapid City, SD 57701\n" +
            "261 Mill Road \n" +
            "Piqua, OH 45356\n" +
            "912 2nd Street East \n" +
            "Rowlett, TX 75088\n" +
            "971 Harrison Avenue \n" +
            "Parlin, NJ 08859\n" +
            "155 9th Street \n" +
            "Independence, KY 41051\n" +
            "944 Adams Street \n" +
            "Wooster, OH 44691\n" +
            "760 Victoria Court \n" +
            "Skokie, IL 60076";

    String [] namesArray= new String[300];
    String [] adresesArray = new String[100];

    private  void init(){
        namesArray =  names.split(" ");
        adresesArray = adresesStr.split(",");
    }

    public String getUserName(){
        return namesArray[((int) (2 * (Math.random() * (namesArray.length / 2))))];

    }

    public String getUserSurName(){
        return namesArray[((int) (1+(2 * (Math.random() * ((namesArray.length) / 2)))))];

    }
    public String generatePhoneNomber(){
        return String.valueOf(800000000 + ((int) ((Math.random() * 100000000))));
    }

    public String generateAdress(){
        return adresesArray[(int)(Math.random() * (adresesArray.length))];
    }

    public Date generateRandDate(){
        long yearTime = 12L * 30L * 24L * 60L * 60L * 1000L;
        Date randomDate = new Date(System.currentTimeMillis()-(long)(Math.random()*yearTime));
        return randomDate;
    }


    public Long createClientsInDB(int quantity){
        Long id = null;

        for (int i = 0; i < quantity; i++) {
            Client client = new Client(namesArray[i], namesArray[i + 1], generatePhoneNomber(), generateAdress(),(Math.random()*1000),generateRandDate());
            id = clientDao.create(client);
            if(i+1>namesArray.length) break;
        }
        return id;
    }
}
