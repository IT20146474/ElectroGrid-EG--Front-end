<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Registration Management</title>
<style>

</style>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css\footer.css"> 
<link rel="stylesheet" type="text/css" href="css\style.css"> 
<script src="components/jquery-3.6.0.js"></script>
<script src="components/main.js"></script>



 <nav class="navbar navbar-expand-md navbar-dark" style="background-color: 	#26272b">
                   

                    <ul class="navbar-nav">
                        <li><a href="Customer.jsp" class="nav">ElectroGrid</a></li>
                    </ul>
                 </nav>
               


</head>
<body>




<br>
<br>
 <h2 class="topic">Registration Management</h2>
<br> 
<div class="container"> 
		<div class="row">  
		 <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                       

                       
                           
                     <div class="body">  
		
			
				<form id="formCustomer" name="formCustomer" method="post" action="Customer.jsp">  
					Customer Name:  
					<input id="regName" name="regName" type="text" class="form-control form-control-sm">  
					
					<br> 
					Customer Email:  
					<input id="regEmail" name="regEmail" type="text" class="form-control form-control-sm">  
					
					<br>
					 Customer Address:  
					 <input id="regAddress" name="regAddress" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					 Customer Phone Number:  
					 <input id="regPNo" name="regPNo" type="text" class="form-control form-control-sm">  
					 
					
					 
					 
					 <br><br>  
					 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn">  
					 <input type="hidden" id="hidcustomerIDSave" name="hidcustomerIDSave" value=""> 
					 
					 
				</form> 
				</div>
				  </div>
                </div>
            </div>
    
				<div id="alertSuccess" class="alert alert-success"></div>  
				<div id="alertError" class="alert alert-danger"></div> 
				
				<br>
					
				
            <div class="row">
               

                <div class="container">
                <br><br><br>
                    <h3 class="text">Customer Details</h3>
                    <hr>
                    
                    <br>
                
                   <div id="divItemsGrid">   
					<%    
						Customer customerObj = new Customer();
						out.print(customerObj.readCustomer());   
					%>  
				
					<br>
					<br>
					 
				</div> 
                   
                </div>
            </div>
				  
 			</div>
 		 
 		</div>    
 		
<br>
	 

</body>

 <!-- Site footer -->
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-6">
            <h6>About</h6>
            <p class="text-justify"> <i> </i> ElectroGrid (EG) is the company who maintains the power grid of the country. They have a system to
monitor the power consumption of the users, generate the monthly bills and automatically send to the
users, and accept the online payments from the users. </p>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Categories</h6>
            <ul class="footer-links">
               <li><a href="Customer.jsp">Registration Management</a></li>
               <li><a href="#">Payment Management</a></li>
               <li><a href="#">Employee Management</a></li>
               <li><a href="#">Billing Management</a></li>
             
            </ul>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Quick Links</h6>
            <ul class="footer-links">
              <li><a href="#">HomePage</a></li>
              <li><a href="#">Contact Us</a></li>
              <li><a href="#">About Us</a></li>
              <li><a href="#">Privacy Policy</a></li>
              
            </ul>
          </div>
        </div>
        <hr>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright &copy; 2022 All Rights Reserved by 
         <a href="#">ElectroGrid</a>.
            </p>
          </div>

         
        </div>
      </div>
</footer>
</html>