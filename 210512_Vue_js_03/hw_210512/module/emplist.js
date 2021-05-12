export default {
  template: `
  <div>
  <input type="text" v-model="word" @input="changed" />
      <table class="table table-bordered">
        <tr :style="appStyle">
          <th>사원아이디</th>
          <th>사원명</th>
          <th>부서</th>
          <th>직책</th>
          <th>연봉</th>
        </tr>
        <tr v-for="emp in filtered">
          <td>{{emp.id}}</td>
          <td>{{emp.name}}</td>
          <td>{{emp.department}}</td>
          <td>{{emp.selectposition}}</td>
          <td>
            {{Math.round(((emp.salary*12)*(1+(emp.comission/100)))/10000)}}
          </td>
        </tr>
      </table>
      </div>
  `,
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
    let localStg = localStorage.getItem("board");
    let list = {
      total: 0,
      items: [],
    };
    list = JSON.parse(localStg);

    this.emplist = list.items;
  },
  computed: {
    filtered: function () {
      var name = this.word.trim();
      return this.emplist.filter(function (item, index) {
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
