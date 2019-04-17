# javaWebServer
在开源中国的博客网址有详细介绍这个代码的截图等，地址：https://my.oschina.net/u/3630543/blog/1791852
jsp+javaBean+Servlet+jdbc+mysql微型网站解析
然后先来说说怎样创建一个Servlet并部署并能被访问。

1.在src下建立一个普通的java类，但继承父类httpServlet.路径是：javax.servlet.http.HttpServlet,然后重写你的doPost()和doGet()方法，并注释掉父类的super.doGet(req,resp)

2.在web-inf下建立classes文件夹，写完以后运行后，在build下找到class文件，把整个包结构都拷贝过去，不是只把class文件拷过去，要包结构和java那边一样的

3.在web.xml下配置servlet的网络访问路径，不配置没法在浏览器访问的。

<servlet>
   <servlet-name>servlet.Servlet</servlet-name>//servlet-name可以随便起，只要两个一模一样就可
   <servlet-class>servlet.Servlet</servlet-class>//真实的包名.文件名全名
  </servlet>
  <servlet-mapping>
    <servlet-name>servlet.Servlet</servlet-name>//servlet-name可以随便起，只要两个一模一样就可

//以这个路径作为访问路径,IP地址:端口号/项目名/servlet.Servlet就可以访问到，名字随便起

 <url-pattern>/servlet.Servlet</url-pattern>
  </servlet-mapping>
