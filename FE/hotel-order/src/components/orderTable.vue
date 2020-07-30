<template>
  <div>
    <el-table
      :data="
        orderlist.slice((currentPage - 1) * PageSize, currentPage * PageSize)
      "
      border
      style="width:100%"
    >
      <el-table-column
        label="订单状态"
        prop="orderstate"
        align="center"
        :formatter="tableFormatter"
        :filters="orderstate"
        :filter-method="filterHandler"
        width="100"
        v-if="!type"
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
        prop="roomid"
        align="center"
        sortable
        width="100"
      ></el-table-column>
      <el-table-column
        label="房型"
        prop="roomtype"
        align="center"
        :formatter="tableFormatter"
        :filters="roomtype"
        :filter-method="filterHandler"
      ></el-table-column>
      <el-table-column
        label="预订时间"
        prop="ordertime"
        align="center"
        width="170"
        :formatter="timeFormatter"
        v-if="type != 1"
      ></el-table-column>
      <el-table-column
        label="预计入住时间"
        prop="preintime"
        align="center"
        width="170"
        :formatter="timeFormatter"
        v-if="type != 1"
      ></el-table-column>
      <el-table-column
        label="入住时间"
        prop="intime"
        align="center"
        :formatter="timeFormatter"
        width="170"
        v-if="type != 2"
      ></el-table-column>
      <el-table-column
        label="预计退房时间"
        prop="preouttime"
        align="center"
        width="170"
        :formatter="timeFormatter"
      ></el-table-column>
      <el-table-column
        label="实际退房时间"
        prop="outtime"
        align="center"
        width="170"
        v-if="!type"
        :formatter="timeFormatter"
      ></el-table-column>
      <el-table-column
        label="是否超时"
        prop="overtime"
        align="center"
        :formatter="tableFormatter"
        v-if="type != 2"
      ></el-table-column>
      <el-table-column
        label="共计"
        prop="total"
        align="center"
        :formatter="totalFormatter"
      ></el-table-column>
      <el-table-column
        label="费用"
        prop="price"
        align="center"
        :formatter="priceFormatter"
      ></el-table-column>
      <el-table-column
        label="操作"
        align="center"
        v-if="type"
        :width="labelWidth"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="checkout(scope.$index, scope.row)"
            v-if="type == 1"
            >退房</el-button
          >
          <el-button
            size="mini"
            @click="checkin(scope.$index, scope.row)"
            v-if="type == 2"
            >入住</el-button
          >
          <el-button
            size="mini"
            @click="cancelBook(scope.$index, scope.row)"
            v-if="type == 2"
            >退订</el-button
          >
        </template>
      </el-table-column>
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
  </div>
</template>

<script>
export default {
  props: {
    orderlist: {
      type: Array,
      default: () => {
        return [];
      }
    },
    type: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      labelWidth: "160",
      map: {
        roombook: "房间预订",
        checkin: "来客入住",
        checkout: "办理退房",
        orderlist: "订单列表",
        roomlist: "房间列表"
      },
      roomtype: [
        { text: "特价房", value: 0 },
        { text: "标准间", value: 1 },
        { text: "大床房", value: 2 }
      ],
      overtime: [
        { text: "否", value: 0 },
        { text: "是", value: 1 }
      ],
      orderstate: [
        { text: "预订中", value: 0 },
        { text: "已入住", value: 1 },
        { text: "已完成", value: 2 },
        { text: "已关闭", value: 3 }
      ],
      // 默认显示第几页
      currentPage: 1,
      // 总条数，根据接口获取数据长度(注意：这里不能为空)
      totalCount: 1,
      // 默认每页显示的条数（可修改）
      PageSize: 10
    };
  },
  mounted() {
    this.totalCount = this.orderlist.length;
    this.labelWidth = this.type == 2 ? "160" : "90";
  },
  methods: {
    checkout(index, row) {
      console.log(index, row);
      this.$confirm("确认退房?", "确认", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
      }).then(() => {
        this.$axios({
          url: "/checkout",
          params: {
            orderid: row.orderid,
            outtime:
              this.formatDate(new Date()) + " " + this.formatTime(new Date())
          }
        }).then(res => {
          if (res.data.code == 0) {
            this.$message({
              type: "success",
              message: "退房成功!"
            });
            this.$store.dispatch("getOrderlist");
            this.$store.dispatch("getRoomlist");
          }
        });
      });
    },
    checkin(index, row) {
      console.log(index, row);
      this.$confirm("确认入住?", "确认", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
      }).then(() => {
        this.$axios({
          url: "/book_to_order",
          params: {
            orderid: row.orderid,
            intime:
              this.formatDate(new Date()) + " " + this.formatTime(new Date())
          }
        }).then(res => {
          if (res.data.code == 0) {
            this.$store.dispatch("getOrderlist");
            this.$store.dispatch("getRoomlist");
            this.$message({
              type: "success",
              message: "入住成功!"
            });
            console.log(res);
          } else {
            this.$message({
              type: "error",
              message: "错误"
            });
          }
        });
      });
    },
    cancelBook(index, row) {
      console.log(index, row);
      this.$confirm("取消预订?", "确认", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
      }).then(() => {
        this.$axios({
          url: "/cancelbook",
          params: {
            orderid: row.orderid
          }
        }).then(res => {
          if (res.data.code == 0) {
            this.$store.dispatch("getOrderlist");
            this.$store.dispatch("getRoomlist");
            this.$message({
              type: "success",
              message: "取消预订成功!"
            });
          } else {
            this.$message({
              type: "error",
              message: "错误"
            });
          }
        });
      });
    },
    tableFormatter(row, col) {
      if (this[col.property][Number(row[col.property])])
        return this[col.property][Number(row[col.property])].text;
      else return "/";
    },

    totalFormatter(row, col) {
      if (row[col.property]) return row[col.property] + "晚";
      else return "/";
    },
    timeFormatter(row, col) {
      if (row[col.property]) return row[col.property];
      else return "/";
    },
    priceFormatter(row, col) {
      if (row[col.property]) return "￥" + row[col.property];
      else return "/";
    },
    // 显示第几页
    handleCurrentChange(val) {
      // 改变默认的页数
      this.currentPage = val;
    },
    filterHandler(value, row, column) {
      const property = column["property"];
      return row[property] === value;
    },
    formatDate(date) {
      return (
        date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate()
      );
    },
    formatTime(time) {
      return (
        time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds()
      );
    }
  }
};
</script>

<style></style>
