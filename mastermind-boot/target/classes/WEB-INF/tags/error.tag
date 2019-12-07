<%@attribute name="field" required="true" %>
<%@attribute name="style" required="false"%>
<%@attribute name="items" type="org.springframework.validation.BindingResult" required="true" rtexprvalue="true"%>
<span style="${style}">${items.hasFieldErrors(field) ? items.getFieldError(field).defaultMessage : ''}</span>