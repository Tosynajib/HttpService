package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class MyHttpService {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(5000),0);
        server.createContext("/", new Handler("/"));
        server.createContext("/about-us", new Handler("/about-us"));
        server.createContext("/contact-us", new Handler("/contact-us"));
        server.createContext("/services", new Handler("/services"));
        server.setExecutor(null);
        server.start();

    }
    static class Handler implements HttpHandler {
        private String path;

        public Handler(String path) {
            this.path = path;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            System.out.println("This is the current path "+path);
            if (Objects.equals(path.length(), 1)){
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "<meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                        " <style>\n" +
                        "        body {\n" +
                        "            margin: 0;\n" +
                        "            font-family: Arial, sans-serif;\n" +
                        "        }\n" +
                        "\n" +
                        "        .carousel-container {\n" +
                        "            width: 80%;\n" +
                        "            margin: 50px auto;\n" +
                        "            overflow: hidden;\n" +
                        "        }\n" +
                        "\n" +
                        "        .carousel {\n" +
                        "            display: flex;\n" +
                        "            transition: transform 0.5s ease-in-out;\n" +
                        "        }\n" +
                        "\n" +
                        "        .carousel img {\n" +
                        "            width: 100%;\n" +
                        "            padding: 10px;\n" +
                        "            border: 2px solid #ccc;\n" +
                        "            box-sizing: border-box;\n" +
                        "        }\n" +
                        "\n" +
                        "        /* Optional: Add media queries for responsiveness */\n" +
                        "        @media (max-width: 768px) {\n" +
                        "            .carousel-container {\n" +
                        "                width: 90%;\n" +
                        "            }\n" +
                        "        }\n" +
                        "    </style>"+
                        "<ul style=\"margin-right: 30rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/Home page>Home</a></li>\n"+
                        "                 <li><a  style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About us</a></li>\n"+
                        "                 <li><a  style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact-us>Contact us</a></li>\n"+
                        "                 <li><a style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+
                        "<br>" +
                        "<body background=\"https://www.cloudtalk.io/wp-content/uploads/2021/12/photo-glovo-thumbnail.png\">\n" +
                        "\n" +
                        "<div class=\"carousel-container\">\n" +
                        "    <div class=\"carousel\" id=\"imageCarousel\">\n" +
                        "        <img src=\"https://research-assets.cbinsights.com/2022/01/05074836/Glovo-Image.png\" alt=\"Image 1\">\n" +
                        "        <img src=\"https://glovoapp.com/images/open-graph-image-glovo.jpeg\" alt=\"Image 3\">\n" +
                        "        <img src=\"https://i0.wp.com/techeconomy.ng/wp-content/uploads/2023/08/Jumia-Food-vs-Glovo-2.png?fit=1080%2C628&ssl=1\" alt=\"Image 2\">\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "\n" +
                        "<script>\n" +
                        "    // JavaScript for automatic sliding\n" +
                        "    let currentIndex = 0;\n" +
                        "    const carousel = document.getElementById('imageCarousel');\n" +
                        "    const images = carousel.getElementsByTagName('img');\n" +
                        "    \n" +
                        "    function showNextImage() {\n" +
                        "        currentIndex = (currentIndex + 1) % images.length;\n" +
                        "        updateCarousel();\n" +
                        "    }\n" +
                        "\n" +
                        "    function updateCarousel() {\n" +
                        "        const translateValue = -currentIndex * 100 + '%';\n" +
                        "        carousel.style.transform = 'translateX(' + translateValue + ')';\n" +
                        "    }\n" +
                        "\n" +
                        "    setInterval(showNextImage, 3000); // Change image every 3 seconds\n" +
                        "</script>"+
                        "<marquee behavior=\"scroll\" direction=\"left\" scrollamount=\"5\" style=\"width: 100%;\">\n" +
                        "  <!-- Insert your image here with inline styling -->\n" +
                        "  <img src=\"https://techlabari.com/wp-content/uploads/2023/08/63f765a7d7f8d5d4c8f9e830_Glovo-Case-Study-860x480.png\" alt=\"SDG 6 - glo \" style=\"height: 100%;\">\n" +
                        "  <img src=\"https://www.hyena.ai/wp-content/uploads/2022/06/How-Much-Does-It-Cost-To-Build-An-App-Like-Glovo.png\n\" alt=\"SDG 6 - glo \" style=\"height: 100%;\">\n"+
                        "</marquee>"+
                        "</body>\n" +
                        "</html>";
            } else if (path.contains("/about-us")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>About Us</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<ul style=\"margin-right: 30rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/Home page>Home</a></li>\n"+
                        "                 <li><a  style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About Us</a></li>\n"+
                        "                 <li><a  style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact-us>Contact us</a></li>\n"+
                        "                 <li><a style=\"color: white; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+
                        "<body background=\"https://images.squarespace-cdn.com/content/v1/57979ccce6f2e1c0953bcaf2/1469728877800-5ILM67CXLQ6Z4ODLPUSL/PF_Background1.jpg?format=2500w\">\n" +
//                        "<h1 color=\"white\" font align=\"center\" face=\"sans-sarif\" size=\"6\">About us</font></h1>\n" +
//                        "\n" +
                        "<br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> \n" +
                        "\n" +
                        "<h1 align=\"center\">\n" +
                        "    <font face=\"sans-sarif\" color=\"#f5f5f5\" size=\"15\">\n" +
                        "Good food start with <br> Good Ingredients"+
//                        "        Customers nowadays would rather order food and other items from an app and have them delivered, <br>\n" +
//                        "        than walk into a neighboring restaurant or store. <br>\n" +
//                        "        The concept of on-demand delivery service has redefined comfort, efficiency, and convenience <br>\n" +
//                        "        for users across every consumer service, product category or just anything.\n" +
                        "    </font>\n" +
                        " <h1/>\n" +
                        "\n" +
//                        "<h1 align=\"center\">\n" +
//                        "    <font face=\"san-serif\" color=\"white\" size=\"5\">\n" +
//                        "        A global technology company Glovo has recently launched its multi-category on-demand delivery <br>\n" +
//                        "        platform in Nigeria!\n" +
//                        "        This app connects users and couriers, allowing them to order any product or food item with <br>\n" +
//                        "        a simple tap on their smartphone and have it delivered to them fast by a specialist Glovo rider, called a Glover.\n" +
//                        "    </font>\n" +
//                        "</h1>\n" +
                        "</body>"+
                        "</html>";
            } else if (path.contains("/contact-us")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Contact Us</title>\n" +
                        "</head>\n" +
                        "<ul style=\"margin-right: 30rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/Home page>Home</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About Us</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact-us>Contact us</a></li>\n"+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+
                        "<br>" +
                        "<body background=\"https://images.squarespace-cdn.com/content/v1/5ac2464f4eddecd0eac509bf/1543410008978-VJ06DVMWHMIHJSSSX7PI/Referencia-Proyectos.jpg?format=1500w\">\n" +
                        "\n" +
                        "<br/> <br/> <br/> <br/> \n" +
                        "<h1> <font color=\"#41875E\" size=\"15\">\n" +
                        "  What services does Glovo offer?\n" +
                        "</font> <br/>\n" +
                        "</h1>\n" +
                        " <h1><font color=\"#41875E\">Anything delivered</font> </h1>\n" +
                        "<br/>\n" +
                        "<h2>\n" +
                        "  <ul> <font color=\"#41875E\">\n" +
                        "    <li>\n" +
                        "      Your city's top restaurants. With a great variety of restaurants <br>\n" +
                        "      you can order your favourite food or explore new restaurants nearby!\n" +
                        "    </li><br>\n" +
                        "    <li>\n" +
                        "      Fast delivery. Like a flash! Order or send anything in your city and <br>\n" +
                        "      receive it in minutes.\n" +
                        "    </li><br>\n" +
                        "    <li>\n" +
                        "      Groceries delivery & more. Find anything you need!\n" +
                        "    </li>\n" +
                        "    <font/>\n" +
                        "  </ul>\n" +
                        "</h2>"+
                        "</body>\n" +
                        "</html>";
            } else if (path.contains("/service")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>About Us</title>\n" +
                        "</head>\n" +
                        "<ul style=\"margin-right: 30rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/Home page>Home</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About Us</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact-us>Contact us</a></li>\n"+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+
                        "<body>\n" +
                        "<br>" +
                        "<body background=\"https://i.vimeocdn.com/video/1578663783-0b91008c76445b8b6131c89c93bccd4d77faa250252ad301a3fb57a09fa9119b-d?f=webp\">\n" +
                        "\n" +
                        "<font color=\"#41875E\" size=\"3\" face=\"sans-serif\">\n" +
                        "  <h1 align=\"center\">Our Offers\"</h1>\n" +
                        "</font>\n" +
                        "<table align=\"center\">\n" +
                        "<tr>\n" +
                        "  <td>\n" +
                        "  <img src=\"https://i2.wp.com/img.aapks.com/imgs/e/0/6/e06950003168cac9f3f4d9a3d8287e1d_fgraphic.png?w=705\" width=\"400\" height=\"400\"/>\n" +
                        "  </td>\n" +
                        "  <td>\n" +
                        "   <img src=\"https://pbs.twimg.com/media/FFwgK6jXMAElw_J.jpg\" width=\"400\" height=\"400\" />\n" +
                        "   </td>\n" +
                        "   <td>\n" +
                        "   <img src=\"https://tobidigital.com/wp-content/uploads/2021/09/about-glovo-app.png\" width=\"400\" height=\"400\" />\n" +
                        "   </td>\n" +
                        "    </tr>"+
                        "  <tr>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://i.pinimg.com/736x/a8/71/4c/a8714cadb2358c6a32ce232025eb13fe.jpg\" width=\"400\" />\n" +
                        "    </td>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://media.contra.com/image/upload/c_limit,fl_lossy,w_850/v1686123379/ln5hfprrinj1lu9vp4kt.png\" width=\"400\" />\n" +
                        "    </td>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://static-sg.winudf.com/wupload/xy/aprojectadmin/YXJ0aWNsZV8xNjgwNDE2MDMwNzgxbHhsZGdrejQ0eWFfMTY4MDQxNjAzMzAxMA.png?imageMogr2/thumbnail/600x\" width=\"400\" height=\"400\" />\n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://blog.pricepally.com/wp-content/uploads/2023/08/Artboard-24-2-1024x536.png\" width=\"400\" height=\"400\" />\n" +
                        "    </td>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://thumbs.dreamstime.com/z/glovo-logo-green-yellow-food-delivery-eat-171067584.jpg?w=1400\" width=\"400\" height=\"400\" />\n" +
                        "    </td>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://media.contra.com/image/upload/ar_1.333,c_fill,f_auto,q_auto,w_384/sf6woeygpme4nyepmowr\" width=\"400\" height=\"400\" />\n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/0d1664182499215.Y3JvcCwzMzExLDI1ODksNDQyLDExNA.jpg\" width=\"400\" height=\"400\" />\n" +
                        "    </td>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://techcrunch.com/wp-content/uploads/2017/10/glover2.jpg?w=1390&crop=1\" width=\"400\" height=\"400\" />\n" +
                        "    </td>\n" +
                        "    <td>\n" +
                        "      <img src=\"https://image.adsoftheworld.com/7ykrs1whvj5nlupnfnzraw9szqyr\" width=\"400\" height=\"400\" />\n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "</table>\n" +
                        "<p align=\"center\">\n" +
                        "  <font face=\"sans-serif\" color=\"black\" >\n" +
                        "  If you are looking for a quick and convenient food delivery,<br>\n" +
                        "  Glovo is here to help! You can order any delivery from various shops and chains, <br>\n" +
                        "  always counting on high quality products and express delivery.<br>\n" +
                        "  Glovo makes it easy for you to get your shopping done without having to leave your home.\n" +
                        "</font>\n" +
                        "</p>\n" +
                        "<p align=\"center\">\n" +
                        "  <font face=\"sans-serif\" color=\"black\" >\n" +
                        "  Ordering from Glovo is simple and quick: <br>\n" +
                        "  All you need to do is open the website or download the app and select from the various categories. <br>\n" +
                        "  Then you can browse the stores offering home delivery and choose the one you want to order from. <br>\n" +
                        "  Add the products to your cart and when you are done, <br>\n" +
                        "  confirm your order and wait for the Glovo courier to bring it to you!\n" +
                        "  </font>\n" +
                        "</p>\n" +
                        "</body>"+
                        "</html>";

            } else{
                response =  "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1> 404 Page Not Found</h1>\n" +
                        "<a href = "+"localhost"+":8085/about-us>About Us</a>\n"+
                        "<a href = "+"localhost"+":8085/>Home page</a>\n"+
                        "</body>\n" +
                        "</html>";
            }


            exchange.getResponseHeaders().set("Content-type","text/html");
            exchange.sendResponseHeaders(200, response.length());
            try(OutputStream outputStream = exchange.getResponseBody()){
                outputStream.write(response.getBytes( StandardCharsets.UTF_8));
            }
        }
    }

}


