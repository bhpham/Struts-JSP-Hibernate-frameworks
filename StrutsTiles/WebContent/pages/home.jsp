<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insert page="/pages/layout.jsp" flush="true">
    <tiles:put name="header" value="/pages/myHeader.jsp" />
    <tiles:put name="menu" value="/pages/myMenu.jsp" />
    <tiles:put name="body" value="/pages/page1.jsp" />
    <tiles:put name="footer" value="/pages/myFooter.jsp" />
</tiles:insert>