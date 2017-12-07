<%-- 
    Document   : admin1
    Created on : Jul 4, 2017, 2:13:37 PM
    Author     : DefF
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="customs.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <body>
         <%
                                        SanPham sp = new SanPham();
                                        ArrayList<SanPham> ar = new ArrayList<SanPham>();
                                        ar=sp.getConnectSanPham();
                                        int start = 0, end = 3;
                                        if(ar.size()<3){
                                            end = ar.size();
                                        }
                                        if ( request.getParameter("start") != null){
                                            start = Integer.parseInt(request.getParameter("start"));
                                        }
                                         if ( request.getParameter("end") != null){
                                            end = Integer.parseInt(request.getParameter("end"));
                                        }
                                         ArrayList<SanPham> list = sp.getlist(ar, start, end);
                                        
                                    %>
                                    <%
                                         int ID;
                                        String TenSP;
                                        String imagesSP;
                                        String GiaSP;
                                        String MoTaSP;
                                    %>
                                    <table border="1" style="width: 800px">
                                        <thead>
                                            <tr>
                                                <th>No.</th>
                                                <th>Ten SP</th>
                                                <th>Hinh Anh</th>
                                                <th>Gia SP</th>
                                                <th>Mo Ta SP</th>
                                            </tr>
                                        </thead>
                                        <%
                                            for ( SanPham sph:list){
                                                ID=sph.getID();
                                           TenSP=sph.getTenSP();
                                           imagesSP=sph.getImagesSP();
                                           GiaSP=sph.getGiaSP();
                                           MoTaSP=sph.getMoTaSP();
                                            
                                        %>
                                        <tr>
                                            <th><%=ID%></th>
                                            <th><%=TenSP%></th>
                                            <th><img src=<%=imagesSP%>/></th>
                                            <th><%=GiaSP%></th>
                                            <th><%=MoTaSP%></th>
                                            <%}%>
                                        </tr>
                                        
                                    </table>
                                        <ul class="pagination" style="margin-left: 40px">
                                             <%
                                        int a,b;
                                        int limit = ar.size()/3;
                                        if (limit * 3 < ar.size()){
                                            limit += 1;
                                            
                                        }
                                        for (int i = 1;i<=limit;i++){
                                            a =(i-1)*3;
                                            b=i*3;
                                            if(b>ar.size()){
                                                b=ar.size();
                                            }
                                        
                                    %>
                                    <li class="active"><a href="admin1.jsp?start=<%=a%>&end=<%=b%>"><%=i%></a></li>
                                        <%}%>
                                        </ul>
                                        <form action="Controller3" method="post" style="width: 300px">
                                            <p> Ten San Pham : <input type="text" name="txtTenSP" style="float: right"/></p> </br>
                                            <p> Hinh Anh: <input type="text" name="txtImage" style="float: right"/></p> </br>
                                            <p> Gia : <input type="text" name="txtGiaSP" style="float: right"/></p> </br>
                                            <p> Mo Ta  : <input type="text" name="txtMoTaSP" style="float: right"/></p> </br>
                                            <input type="submit" value="Update" name="btnAction"/>
                                            <input type="submit" value="Delete" name="btnAction"/>
                                            <input type="submit" value="Reset" name="btnAction"/>
                                        </form>
    </body>
</html>
