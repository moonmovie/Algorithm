<template>
<tr>
    <td>{{emp.id}}</td>
    <td>{{emp.name}}</td>
    <td>{{emp.dname}}</td>
    <td>{{emp.title}}</td>
    <td>
      {{Math.round(((emp.salary*12)*(1+(emp.commission_pct/100))))}}
    </td>
</tr>
                     
</template>

<script>
export default {
    name:'emplist',
    props:['emp',],

}
</script>

<style>

</style>