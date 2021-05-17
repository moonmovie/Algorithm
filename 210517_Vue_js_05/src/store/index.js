import Vue from "vue";
import Vuex from "vuex";
import http from "@/components/axios";
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    emps: [],
  },
  getters: {},

  mutations: {
    SHOW_EMPS(state, list) {
      state.emps = list;
    },
  },
  actions: {
    showemps({ commit }) {
      http
        .get("/list")
        .then(({ data }) => {
          commit("SHOW_EMPS", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    addemps(data, empone) {
      http
        .post("/new", {
          title: empone.title,
          name: empone.name,
          mailid: empone.mailid,
          start_date: empone.start_date,
          manager_id: empone.manager_id,
          dept_id: empone.dept_id,
          salary: empone.salary,
          commission_pct: empone.commission_pct,
        })
        .then(({ data }) => {
          console.log(data);
          alert("추가되었습니다.");
          // $router.push("/");
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
  },
});
