<template>
  <section class="section">
    <el-table :data="roomlist" border style="width:100%">
      <el-table-column
        label="房间号"
        prop="roomID"
        align="center"
      ></el-table-column>
      <el-table-column
        label="房间类型"
        prop="roomtype"
        align="center"
      ></el-table-column>
      <el-table-column
        label="价格"
        prop="price"
        align="center"
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
      ></el-table-column>
      <el-table-column
        label="面积"
        prop="area"
        align="center"
      ></el-table-column>
      <el-table-column
        label="是否含早"
        prop="includebrk"
        align="center"
      ></el-table-column>
      <el-table-column
        label="状态"
        prop="status"
        align="center"
      ></el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >预订</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </section>
</template>

<script>
export default {
  data() {
    return {
      map: {
        roombook: '房间预订',
        checkin: '来客入住',
        checkout: '办理退房',
        orderlist: '订单列表',
        roomlist: '房间列表',
      },
      roomlist: [],
    }
  },
  mounted() {
    this.roomlist = this.$store.state.roomlist
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row)
    },
  },
}
</script>

<style>
.section {
  padding: 20px;
}
</style>
