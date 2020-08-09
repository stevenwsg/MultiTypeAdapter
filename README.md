# MultiTypeAdapter

仿MultiType实现ListViewAdapter

# 使用
### 1、创建数据实体

```
data class TextItem(val text : String)
```
### 2、创建ViewHolder

```
class TextViewHolder : BaseViewHolder<TextItem>() {

    private var text: TextView? = null

    override fun getLayoutId(): Int {
        return R.layout.item_text //返回VH的布局文件
    }

    override fun onBindViewHolder(rootView: View) {
        text = rootView.findViewById(R.id.text) //绑定View
    }

    override fun render(item: TextItem, position: Int) {
        text?.text = item.text //渲染View
    }
}
```

### 3、Adapter绑定ViewHolder,注入数据


```
class MainActivity : AppCompatActivity() {

    private var mList: MutableList<Any>? = null
    private var mListView: ListView? = null
    private var adapter: MultiTypeListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData();
        initAdapter();

        mListView = findViewById(R.id.listview)
        mListView?.adapter = adapter
    }

    private fun initData() {
        mList = ArrayList()
        for (i in 1..100) {
            mList?.add(ImageItem(R.mipmap.ic_launcher))
            mList?.add(RichItem("小艾大人赛高", R.drawable.ic_launcher_foreground))
            mList?.add(TextItem("没有什么能够阻挡，你对自由的向往~"))
        }
    }

    //注册ViewHolder
    private fun initAdapter() {
        adapter = MultiTypeListViewAdapter(this, mList)
        adapter?.register(RichItem::class.java, RichTextViewHolder())
        adapter?.register(ImageItem::class.java, ImageViewHolder())
        adapter?.register(TextItem::class.java, TextViewHolder())
    }
}
```
# 实现效果
![image](https://i.loli.net/2020/08/09/34sa1uLDT2iU7OZ.png)
# WIKI

