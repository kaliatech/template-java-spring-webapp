<#assign title="section1 | mycompany"/>
<#assign mainMenu="section1" />
<#assign content>
<h1>Section 1.</h1>

<div class="row-fluid">
    <div class="span12">
        <h2>Section 1</h2>
        <p>Some notes about section 1</p>
    </div>

</div>

<div class="row-fluid">
    <div class="span12">
        <h2>My Simple Entities</h2>
        <#list mySimpleEntities as mySimpleEntity>
        	${mySimpleEntity.id} - ${mySimpleEntity.status}</br> 
        </#list>

    </div>

</div>


</#assign>
<#include "../tpl-master.ftl">
