<template>
  <section class="section">
    <el-table
      :data="
        roomlist.slice((currentPage - 1) * PageSize, currentPage * PageSize)
      "
      border
      style="width:100%"
    >
      <el-table-column
        label="房间号"
        prop="roomID"
        align="center"
        sortable
      ></el-table-column>
      <el-table-column
        label="房间类型"
        prop="roomtype"
        align="center"
        :formatter="typeFormatter"
        :filters="roomtype"
        :filter-method="filterHandler"
        sortable
      ></el-table-column>
      <el-table-column
        label="价格"
        prop="price"
        align="center"
        sortable
      ></el-table-column>
      <el-table-column
        label="适合人数"
        prop="numofpeople"
        align="center"
        sortable
      ></el-table-column>
      <el-table-column
        label="楼层"
        prop="floor"
        align="center"
        sortable
      ></el-table-column>
      <el-table-column
        label="面积"
        prop="area"
        align="center"
        sortable
      ></el-table-column>
      <el-table-column
        label="是否含早"
        prop="includebrk"
        align="center"
        :formatter="brkFormatter"
        sortable
      ></el-table-column>
      <el-table-column
        label="状态"
        prop="status"
        align="center"
        :formatter="statusFormatter"
        :filters="roomstatus"
        :filter-method="filterHandler"
        sortable
      ></el-table-column>
    </el-table>
    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="PageSize"
      layout="total, prev, pager, next"
      :total="totalCount"
      style="margin: 20px 0 0 30px;"
    >
    </el-pagination>
  </section>
</template>

<script>
export default {
  data() {
    return {
      map: {
        roombook: "房间预订",
        checkin: "来客入住",
        checkout: "办理退房",
        orderlist: "订单列表",
        roomlist: "房间列表"
      },
      roomlist: [],
      dialogFormVisible: false,
      formLabelWidth: "120px",
      form: {
        guestid: "",
        name: "",
        phone: "",
        roomid: "",
        ordertime: "",
        preintime: "",
        preouttime: "",
        total: ""
      },
      roomtype: [
        { text: "特价房", value: 0 },
        { text: "标准间", value: 1 },
        { text: "大床房", value: 2 }
      ],
      breakfast: ["否", "是"],
      roomstatus: [
        { text: "空闲", value: 0 },
        { text: "预订中", value: 1 },
        { text: "已入住", value: 2 }
      ],
      selectType: "",
      // 默认显示第几页
      currentPage: 1,
      // 总条数，根据接口获取数据长度(注意：这里不能为空)
      totalCount: 1,
      // 默认每页显示的条数（可修改）
      PageSize: 10
    };
  },
  mounted() {
    this.roomlist = this.$store.state.roomlist;
    this.totalCount = this.roomlist.length;
  },
  methods: {
    handle(index, row) {
      this.dialogFormVisible = true;
      console.log(index, row);
    },
    typeFormatter(row) {
      return this.roomtype[Number(row.roomtype)].text;
    },
    brkFormatter(row) {
      return this.breakfast[Number(row.includebrk)];
    },
    statusFormatter(row) {
      return this.roomstatus[Number(row.status)];
    },
    // 显示第几页
    handleCurrentChange(val) {
      // 改变默认的页数
      this.currentPage = val;
    },
    filterHandler(value, row, column) {
      const property = column["property"];
      return row[property] === value;
    }
  }
};
</script>

<style>
.section {
  padding: 20px;
}
</style>
