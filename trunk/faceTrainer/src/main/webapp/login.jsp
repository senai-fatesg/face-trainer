<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html; charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> Faces Trainer </title>

    <link href="css/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
	<link rel="shortcut icon" href="resources/img/favicon.ico" type="image/x-icon"/>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />

	<script>
		function focar() {
			document.getElementById("usuario").focus();
		}
	</script>
</head>
<body>
<form action="j_spring_security_check" method="post">

<div class="wrapper">
	<div class="header">
    	<div class="container">
        	<div class="row branding">
            	<div class="span6">
                	<h1 class="pull-left"><a href="index.xhtml"><strong>Faces Trainer</strong></a></h1>
                </div>            	
            </div>
        </div>        
    </div>
	<div class="container content">
        <div class="row">
            <div class="span8 leftContent">
            	<h2>Como Funciona: </h2>
                <div class="row">
                	<div class="span4">
                    	<p class="cntPara simpleDesign" align="justify">
                        	<strong class="lead">Cadastro</strong>
                        </p>   
                        <img src="resources/img/cadastro.png"  align="top" style="margin-left: 200px"  />         	                                                
                        <p class="cntPara simpleDesign" align="center">	
							Realize seu cadastro no sistem com seu nome 
							e email;
							<a href="cadastro.jsp">cadastre-se</a> <br/>
							
							
						</p>                         	
                    </div>
                    
                    <div class="span4">
                    	<p class="cntPara itsFree" align="justify">
                        	<strong class="lead">Fotografia</strong>
                       </p>      
                       <img src="resources/img/camera.png"  align="top" style="margin-left:195px"  />
                       <p class="cntPara itsFree" align="center">
							Depois que voce realizar seu cadastro, tire varias fotos <br />
							e deixe registrado no nosso sitema para treinamento; 
                       </p>
                    </div>                                        
                
                </div>
                <hr/>
                <div class="row">
                	<div class="span4">
                    	<p class="cntPara secureApp"  align="justify">
                        	<strong class="lead">Treinamento</strong>
                    	</p>
                    	<img src="resources/img/treinamento.png"  align="top" style="margin-left: 200px"  />
                    	<p class="cntPara secureApp"  align="center">
							Essa stapa já e conosco, depois que você tirar as fotos
							vamos iniciar uma serie de treinamento para que nossos
							software possa te reconhcer o mais breve possivel.
                    	
                    	</p>
                    </div>
                    
                    <div class="span4">
                    	<p class="cntPara secureApp" align="justify">
                        	<strong class="lead">Detecção e Reconhecimento </strong>
                        </p>      
                        <img src="resources/img/reconhecimento.png"  align="top" style="margin-left: 195px" width="74px" height="74px"  />
                        <p class="cntPara secureApp" align="center">
							Nosso treinamento e realizado a cada 30min, depois desse periodo nosso software
							vai estar capacitado a realizar a detecção e o reconhecimento do seu rosto. 
						</p>                        
                        	
                    </div>                                        
                </div>
                <hr/>   
            </div>
            
            <div class="span4 sidebar" >
                <h2><a href="cadastroUsuario.xhtml" class="btn btn-large btn-primary"> Novo Cadastro </a></h2>
               
<!--                 <div class="well quickSignupForm"> -->
<!--                   <h3>Acesso ao Sistema</h3> -->
<%-- 					<% --%>
<!-- // 					if (request.getParameter("msg") != null) { -->
<!-- // 						out.print("<span style='color: red;font-weight: bold;'>Usuário ou senha incorretos</span>"); -->
<%-- 					}%>		 --%>
<!--                   <label>Login</label> -->
<!--                   <input type="text" id="usuario" name="j_username" class="span3"  /> -->
<!--                   <label>Senha</label> -->
<!--                   <input name="j_password" type="password" class="span3" />       	            -->
<!--                   <input class="btn btn-large btn-success btnSignup" type="submit" value="Entrar" /> -->
<!--                 </div> -->
                
            </div>
            
    	</div>
    </div>
</div>
</body>
</html>