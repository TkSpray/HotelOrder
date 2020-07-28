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
        label="价格"
        prop="price"
        align="center"
        sortable
        width="100"
      ></el-table-column>
      <el-table-column
        label="适合人数"
        prop="numofpeople"
        align="center"
      ></el-table-column>
      <el-table-column
        label="楼层"
        prop="floor"
        align="center"
        sortable
        width="90"
      ></el-table-column>
      <el-table-column
        label="面积"
        prop="area"
        align="center"
        sortable
        width="90"
        :formatter="areaFormatter"
      ></el-table-column>
      <el-table-column
        label="是否含早"
        prop="includebrk"
        align="center"
        :formatter="tableFormatter"
      ></el-table-column>
      <el-table-column
        label="状态"
        prop="status"
        align="center"
        :formatter="tableFormatter"
        :filters="status"
        :filter-method="filterHandler"
        v-if="!type"
      ></el-table-column>
      <el-table-column label="操作" align="center" v-if="type">
        <template slot-scope="scope">
          <el-button size="mini" @click="handle(scope.$index, scope.row)">{{
            type == 1 ? "预订" : "办理"
          }}</el-button>
        </template>
      </el-table-column>
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
    <el-dialog
      title="身份信息输入"
      :visible.sync="dialogFormVisible"
      width="550px"
      v-if="type"
    >
      <el-form :model="form">
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input
            v-model="form.name"
            autocomplete="off"
            style="width:55%"
          ></el-input>
        </el-form-item>
        <el-form-item label="电话" :label-width="formLabelWidth">
          <el-input
            v-model="form.phone"
            autocomplete="off"
            style="width:55%"
          ></el-input>
        </el-form-item>
        <el-form-item label="身份证号" :label-width="formLabelWidth">
          <el-input
            v-model="form.guestid"
            autocomplete="off"
            style="width:55%"
          ></el-input>
        </el-form-item>
        <el-form-item label="预计入住时间" :label-width="formLabelWidth">
          <el-date-picker
            v-model="date"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          >
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirmInfo()">确 定</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
export default {
  props: {
    roomlist: {
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
      includebrk: [
        { text: "否", value: 0 },
        { text: "是", value: 1 }
      ],
      status: [
        { text: "空闲", value: 0 },
        { text: "预订中", value: 1 },
        { text: "已入住", value: 2 }
      ],
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
      date: [],
      dialogFormVisible: false,
      formLabelWidth: "120px",
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
    this.totalCount = this.roomlist.length;
  },
  methods: {
    handle(index, row) {
      this.dialogFormVisible = true;
      this.form.roomid = row.roomID;
      console.log(index, row);
    },
    tableFormatter(row, col) {
      return this[col.property][Number(row[col.property])].text;
    },
    areaFormatter(row, col) {
      return row[col.property] + "平米";
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
    },
    confirmInfo() {
      const nowData = new Date();
      this.dialogFormVisible = false;
      let days = (this.date[1] - this.date[0]) / (24 * 60 * 60 * 1000);
      let start = this.formatDate(this.date[0]);
      let end = this.formatDate(this.date[1]);

      this.form.ordertime =
        this.formatDate(nowData) + " " + this.formatTime(nowData);
      this.form.preintime = start;
      this.form.preouttime = end;
      this.form.total = days;
      console.log(start, end, days, this.form);
    }
  }
};
</script>

<style>
.section {
  padding: 20px;
}
</style>
