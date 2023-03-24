import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.location.databinding.ItemCountryBinding
import com.example.location.models.CountriesItem

class CountriesAdapter: ListAdapter<CountriesItem, CountriesAdapter.CountriesItemViewHolder>(DiffCallback)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesAdapter.CountriesItemViewHolder {
        return CountriesItemViewHolder(ItemCountryBinding.inflate(LayoutInflater.from(parent.context)))
    }

    companion object DiffCallback: DiffUtil.ItemCallback<CountriesItem>() {
        override fun areItemsTheSame(oldItem: CountriesItem, newItem: CountriesItem): Boolean {
            return oldItem.code == newItem.code
        }

        override fun areContentsTheSame(oldItem: CountriesItem, newItem: CountriesItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: CountriesAdapter.CountriesItemViewHolder, position: Int) {
        val countries = getItem(position)
        holder.bind(countries)
    }

    class CountriesItemViewHolder(private val binding: ItemCountryBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(countries: CountriesItem) {
            binding.nameRegion.text = countries.name +", " + countries.region
            binding.code.text = countries.code
            binding.capital.text = countries.capital
            binding.executePendingBindings()
        }
    }
}