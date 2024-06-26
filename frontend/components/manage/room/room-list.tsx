"use client";
import DropdownSkeleton from "@/components/skeleton/dropdown-skeleton";
import { Button } from "@/components/ui/button";
import {
  Command,
  CommandGroup,
  CommandItem,
  CommandList,
} from "@/components/ui/command";
import {
  Popover,
  PopoverContent,
  PopoverTrigger,
} from "@/components/ui/popover";
import getAllResources from "@/lib/resources/getAllResources";
import getAllRoom from "@/lib/room/getAllRoom";
import { cn } from "@/lib/utils";
import { Resource } from "@/types";
import React, { useEffect, useState } from "react";
import { LuCheck, LuChevronsUpDown } from "react-icons/lu";

export interface ResourceListProps {
  room: string | number;
  setRoom: (room: string | number) => void;
  isId: boolean;
  readonly?: boolean;
}
const ResourceList = ({ isId, room, setRoom, readonly }: ResourceListProps) => {
  const [open, setOpen] = useState(false);
  const { rooms, isLoading, isError } = getAllRoom({
    name: "",
    limit: "10000",
    page: "1",
  });
  const [resourceList, setResourceList] = useState<Array<Resource>>([]);
  useEffect(() => {
    if (rooms) {
      setResourceList(rooms.data);
    }
  }, [rooms]);
  if (isError) return <div>Failed to load</div>;
  if (!rooms) {
    return <DropdownSkeleton />;
  } else {
    return (
      <Popover open={open} onOpenChange={setOpen}>
        <PopoverTrigger asChild>
          <Button
            disabled={readonly}
            variant="outline"
            role="combobox"
            aria-expanded={open}
            className="justify-between w-full min-w-0 h-10 rounded-full"
          >
            {room && room !== -1
              ? resourceList.find(
                  (item) =>
                    (isId && item.id.toString() === room.toString()) ||
                    (!isId && item.name === room)
                )?.name
              : "Chọn phòng họp"}
            <LuChevronsUpDown className="ml-2 h-4 w-4 shrink-0 opacity-50" />
          </Button>
        </PopoverTrigger>
        <PopoverContent className="PopoverContent rounded-xl w-full">
          <Command className="w-full">
            <CommandList>
              <CommandGroup>
                {resourceList.map((item) => (
                  <CommandItem
                    value={item.name}
                    key={item.id}
                    onSelect={() => {
                      if (isId) {
                        setRoom(item.id);
                      } else {
                        setRoom(item.name);
                      }
                      setOpen(false);
                    }}
                  >
                    <LuCheck
                      className={cn(
                        "mr-2 h-4 w-4",
                        isId
                          ? item.id.toString() === room.toString()
                            ? "opacity-100"
                            : "opacity-0"
                          : item.name === room
                          ? "opacity-100"
                          : "opacity-0"
                      )}
                    />
                    {item.name}
                  </CommandItem>
                ))}
              </CommandGroup>
            </CommandList>
          </Command>
        </PopoverContent>
      </Popover>
    );
  }
};

export default ResourceList;
