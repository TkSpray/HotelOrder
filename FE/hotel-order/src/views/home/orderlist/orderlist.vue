<template>
  <section class="section">
    <header class="orderlist-search">
      <el-input
        placeholder="请输入内容"
        v-model="searchData"
        class="input-with-select"
        clearable
        @change="search"
      >
        <el-select
          v-model="searchType"
          slot="prepend"
          placeholder="请选择"
          @change="reset"
        >
          <el-option label="姓名" value="name"></el-option>
          <el-option label="电话" value="phone"></el-option>
          <el-option label="身份证号" value="guestid"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </header>

    <orderTable :orderlist="orderlist" :type="0" />
  </section>
</template>

<script>
import orderTable from "../../../components/orderTable";
export default {
  components: {
    orderTable
  },
  data() {
    return {
      orderlist: [],
      searchData: "",
      searchType: "name"
    };
  },
  mounted() {
    this.orderlist = this.alllist;
  },
  computed: {
    alllist() {
      return this.$store.state.orderlist;
    }
  },
  methods: {
    search() {
      if (this.searchData) {
        this.orderlist = this.alllist.filter(item => {
          if (item[this.searchType].indexOf(this.searchData) != -1) return true;
        });
      } else this.orderlist = this.alllist;
    },
    reset() {
      this.orderlist = this.alllist;
    }
  }
};
</script>

<style>
.orderlist-search {
  margin-bottom: 20px;
  width: 500px;
}
.el-select {
  width: 110px;
}
</style>
