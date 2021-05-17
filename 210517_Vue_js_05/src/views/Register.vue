<template>
  <div class="container">
    <table class="table table-bordered">
      <tr>
        <td class="head">이름</td>
        <td><input type="text" v-model="name" /></td>
      </tr>
      <tr>
        <td class="head">이메일</td>
        <td><input type="email" v-model="mailid" /></td>
      </tr>
      <tr>
        <td class="head">고용일</td>
        <td><input type="date" v-model="start_date" /></td>
      </tr>
      <tr>
        <td class="head">관리자</td>
        <td>
          <select v-model="manager_id">
          <option v-for="option in managers" :key="option.id" v-bind:value="option.id">
            {{ option.name }}
          </option>
        </select>
        </td>
      </tr>
      <tr>
        <td class="head">직책</td>
        <td>
          <select v-model="title">
          <option v-for="option in positions" :key="option.value" v-bind:value="option.value">
            {{ option.text }}
          </option>
        </select>
        </td>
      </tr>
      <tr>
        <td class="head">부서</td>
        <td>
          <select v-model="dept_id">
            <option v-for="option in departments" :key="option.dept_id" v-bind:value="option.dept_id">
              {{ option.dept_id+"|" + option.name }}
            </option>
          </select>
        </td>
        <!-- <td><input type="text" v-model="department" /></td> -->
      </tr>
      <tr>
        <td class="head">월급</td>
        <td><input type="text" v-model="salary" /></td>
      </tr>
      <tr>
        <td class="head">커미션</td>
        <td><input type="text" v-model="commission_pct" /></td>
      </tr>
      <tr>
        <td class="text-center" colspan="2">
          <button @click="addlist">사원추가</button>
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
import http from '@/components/axios';
export default {
  name: "Register",
  data() {
    return {
      title: "",
      id: "",
      name: "",
      mailid: "",
      start_date: "",
      manager_id: "",
      dept_id:"",
      departments: [],
      salary: "",
      commission_pct: "",
      positions: [
        { text: "사장", value: "사장" },
        { text: "기획부장", value: "기획부장" },
        { text: "영업부장", value: "영업부장" },
        { text: "총무부장", value: "총무부장" },
        { text: "인사부장", value: "인사부장" },
        { text: "과장", value:"과장" },
        { text: "영업대표이사", value: "영업대표이사" },
        { text: "사원", value: "사원" },
      ],
      managers: [],
    };
  },
  methods: {
    
    addlist: function () {
      
      let empOne={
        title: this.title,
        name: this.name,
        mailid: this.mailid,
        start_date: this.start_date,
        manager_id: this.manager_id,
        dept_id: this.dept_id,
        salary: this.salary,
        commission_pct: this.commission_pct,
      };
      this.$store.dispatch('addemps',empOne);
    },
  },
  created() {
    this.manager_id="1";
    this.title="사원";
    this.dept_id="110";
    http.get('/list').then(({data})=>{
     data.forEach(ele => {
       if(ele.title!="사원"){
         this.managers.push(ele);
       }
     });
    }).catch(()=>{
      alert('에러가 발생했습니다.');
    });

    http.get('/deptlist').then(({data})=>{
      this.departments=data;
    }).catch(()=>{});
  },
};
</script>

<style>
/* @import "https://cdn-css-file.css"; */
</style>
