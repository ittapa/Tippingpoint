<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%
request.setCharacterEncoding("UTF-8");

String LGD_RESPCODE = request.getParameter("LGD_RESPCODE");
String LGD_RESPMSG 	= request.getParameter("LGD_RESPMSG");

Map payReqMap = request.getParameterMap();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>카드결제 응답 페이지</title>
</head>
<body>
     <script type="text/javascript">

		function setLGDResult() {
			///parent.payment_return();
			try {
			} catch (e) {
				alert(e.message);
			}
		}
		
		window.onload = function(){
			setLGDResult();
			// 페이지 전환...?
					
		}
	</script>
	<h1>카드 인증결과</h1>
	<div>
	<p>LGD_RESPCODE (결과코드) : <%= LGD_RESPCODE %></p>
	<p>LGD_RESPMSG (결과메시지): <%= LGD_RESPMSG %></p>
	<form method="post" name="LGD_RETURNINFO" id="LGD_RETURNINFO">
	<%
	for (Iterator i = payReqMap.keySet().iterator(); i.hasNext();) {
		Object key = i.next();
		if (payReqMap.get(key) instanceof String[]) {
			String[] valueArr = (String[])payReqMap.get(key);
			for(int k = 0; k < valueArr.length; k++)
				out.println("<input type='hidden' name='" + key + "' id='"+key+"'value='" + valueArr[k] + "'/>");
		} else {
			String value = payReqMap.get(key) == null ? "" : (String) payReqMap.get(key);
			out.println("<input type='hidden' name='" + key + "' id='"+key+"'value='" + value + "'/>");
		}
	}
	%>
	</form>
	</div>
</body>
</html>