package xyz.gaborohez.starwarsencyclopedia.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.gaborohez.starwarsencyclopedia.data.Character;
import xyz.gaborohez.starwarsencyclopedia.databinding.ItemCharacterBinding;

public class ItemCharacterAdapter extends RecyclerView.Adapter<ItemCharacterAdapter.ViewHolder> {

    private final List<Character> list;
    private final ItemCharacterIn listener;

    public ItemCharacterAdapter(List<Character> list, ItemCharacterIn listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Character character = list.get(position);

        holder.binding.tvGender.setText(character.getGender());
        holder.binding.tvName.setText(character.getName());
        holder.binding.contentItem.setOnClickListener(v -> listener.onCharacterClick(character));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemCharacterIn {
        void onCharacterClick(Character character);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemCharacterBinding binding;

        public ViewHolder(ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
