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
          <emp-tr v-for="emp in filtered" :key="emp.id" :emp="emp"/>
        </table>
  </div>
</template>

<script>
// @ is an alias to /src
import EmpTr from '@/components/emplist';
export default {
  name: "Home",
  components:{EmpTr},
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
     this.$store.dispatch('showemps');
  },
  computed: {
    
    filtered: function () {
      var name = this.word.trim();
      return this.$store.state.emps.filter(function (item) {
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
