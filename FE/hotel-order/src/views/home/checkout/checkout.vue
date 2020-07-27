<template>
  <section class="section">
    <el-table
      :data="
        orderlist.slice((currentPage - 1) * PageSize, currentPage * PageSize)
      "
      border
      style="width:100%"
    >
      <el-table-column
        label="订单状态"
        prop="orderstatus"
        align="center"
        :formatter="statusFormatter"
        :filters="roomstatus"
        :filter-method="filterHandler"
        width="100"
      ></el-table-column>
      <el-table-column
        label="姓名"
        prop="name"
        align="center"
      ></el-table-column>
      <el-table-column
        label="手机号码"
        prop="phone"
        align="center"
        width="130"
      ></el-table-column>
      <el-table-column
        label="身份证号码"
        prop="guestid"
        align="center"
        width="170"
      ></el-table-column>
      <el-table-column
        label="房间号"
        prop="roomId"
        align="center"
        sortable
        width="100"
      ></el-table-column>
      <el-table-column
        label="房型"
        prop="roomtype"
        align="center"
        :formatter="typeFormatter"
        :filters="roomtype"
        :filter-method="filterHandler"
      ></el-table-column>
      <el-table-column
        label="预订时间"
        prop="ordertime"
        align="center"
        width="170"
      ></el-table-column>
      <el-table-column
        label="预计入住时间"
        prop="preintime"
        align="center"
        width="170"
      ></el-table-column>
      <el-table-column
        label="入住时间"
        prop="intime"
        align="center"
        width="170"
      ></el-table-column>
      <el-table-column
        label="预计退房时间"
        prop="preouttime"
        align="center"
        width="170"
      ></el-table-column>
      <el-table-column
        label="实际退房时间"
        prop="outtime"
        align="center"
        width="170"
      ></el-table-column>
      <el-table-column
        label="是否超时"
        prop="overtime"
        align="center"
        :formatter="overtimeFormatter"
      ></el-table-column>
      <el-table-column
        label="共计"
        prop="total"
        align="center"
      ></el-table-column>
      <el-table-column
        label="费用"
        prop="price"
        align="center"
      ></el-table-column>
    </el-table>
    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="PageSize"
      layout=" prev, pager, next,jumper"
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
      orderlist: [],
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
      overtime: ["否", "是"],
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
    this.orderlist = this.$store.state.orderlist;
    this.totalCount = this.orderlist.length;
  },
  methods: {
    handle(index, row) {
      this.dialogFormVisible = true;
      console.log(index, row);
    },
    typeFormatter(row) {
      return this.roomtype[Number(row.roomtype)].text;
    },
    overtimeFormatter(row) {
      return this.overtime[Number(row.overtime)];
    },
    statusFormatter(row) {
      return this.roomstatus[Number(row.orderstatus)].text;
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
