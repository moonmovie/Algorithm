<template>
  <div class="container">
        <input type="text" v-model="word" @input="changed" />
        <table class="table table-bordered">
          <tr :style="appStyle">
            <th>사원아이디</th>
            <th>사원명</th>
            <th>부서</th>
            <th>직책</th>
            <th>연봉</th>
          </tr>
          <tr v-for="emp in filtered" :key="emp.id">
            <td>{{emp.id}}</td>
            <td>{{emp.name}}</td>
            <td>{{emp.dname}}</td>
            <td>{{emp.title}}</td>
            <td>
              {{Math.round(((emp.salary*12)*(1+(emp.commission_pct/100))))}}
            </td>
          </tr>
        </table>
  </div>
</template>

<script>
// @ is an alias to /src
import http from '@/components/axios';
export default {
  name: "Home",
  
  data() {
    return {
      word: "",
      emplist: [],
      appStyle: {
        backgroundColor: "cornflowerblue",
      },
    };
  },
  created() {
    http.get('/list').then(({data})=>{
     this.emplist=data;
    }).catch(()=>{
      alert('에러가 발생했습니다.');
    });
  },
  computed: {
    filtered: function () {
      var name = this.word.trim();
      return this.emplist.filter(function (item) {
        if (item.name.indexOf(name) > -1) {
          return true;
        }
      });
    },
  },
  methods: {
    changed: function (e) {
      this.word = e.target.value;
    },
  },
};
</script>
