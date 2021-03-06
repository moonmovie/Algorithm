export default {
  template: `
    <table class="table table-bordered">
    <tr>
      <td class="head">이름</td>
      <td><input type="text" v-model="name" /></td>
    </tr>
    <tr>
      <td class="head">이메일</td>
      <td><input type="email" v-model="email" /></td>
    </tr>
    <tr>
      <td class="head">고용일</td>
      <td><input type="date" v-model="joindate" /></td>
    </tr>
    <tr>
      <td class="head">관리자</td>
      <td>
        <select v-model="manager">
          <option v-for="option in managers" v-bind:value="option.value">
            {{ option }}
          </option>
        </select>
        <!-- <input type="text" v-model="manager" /> -->
      </td>
    </tr>
    <tr>
      <td class="head">직책</td>
      <td>
        <select v-model="selectposition">
          <option v-for="option in positions" v-bind:value="option.value">
            {{ option.text }}
          </option>
        </select>
      </td>
    </tr>
    <tr>
      <td class="head">부서</td>
      <td><input type="text" v-model="department" /></td>
    </tr>
    <tr>
      <td class="head">월급</td>
      <td><input type="text" v-model="salary" /></td>
    </tr>
    <tr>
      <td class="head">커미션</td>
      <td><input type="text" v-model="comission" /></td>
    </tr>
    <tr>
      <td class="text-center" colspan="2">
        <button @click="addlist">사원추가</button>
      </td>
    </tr>
  </table>
    `,
  data() {
    return {
      selectposition: "",
      id: "",
      name: "",
      email: "",
      joindate: "",
      manager: "김싸피",
      department: "",
      salary: "",
      comission: "",
      positions: [
        { text: "사장", value: "president" },
        { text: "기획부장", value: "enterprise" },
        { text: "영업부장", value: "sales" },
        { text: "총무부장", value: "affairs" },
        { text: "인사부장", value: "humanre" },
        { text: "과장", value: "manager" },
        { text: "영업대표이사", value: "salseceo" },
        { text: "사원", value: "emp" },
      ],
      managers: [],
    };
  },
  methods: {
    addlist: function () {
      const board = localStorage.getItem("board");
      let newboard = {
        total: 0,
        items: [],
      };

      if (board) {
        newboard = JSON.parse(board);
      }
      newboard.total += 1;
      newboard.items.push({
        id: newboard.total,
        selectposition: this.selectposition,
        name: this.name,
        email: this.email,
        joindate: this.joindate,
        manager: this.manager,
        department: this.department,
        salary: this.salary,
        comission: this.comission,
      });

      localStorage.setItem("board", JSON.stringify(newboard));
      alert("등록완료");

      location.href = "index.html";
    },
  },
  created() {
    this.selectposition = "emp";
    this.manager = "김싸피";
    const board = localStorage.getItem("board");
    let newboard = {
      total: 0,
      items: [],
    };
    if (board) {
      newboard = JSON.parse(board);
      console.log(newboard);
      for (let i = 0; i < newboard.total; i++) {
        if (newboard.items[i].selectposition != "emp") {
          this.managers.push(newboard.items[i].name);
        }
      }
    }
  },
};
